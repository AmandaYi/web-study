package logic

import (
	"book/common/errorx"
	"book/service/user/model"
	"context"
	"errors"
	"github.com/golang-jwt/jwt/v4"
	"strings"
	"time"

	"book/service/user/api/internal/svc"
	"book/service/user/api/internal/types"

	"github.com/zeromicro/go-zero/core/logx"
)

type LoginLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewLoginLogic(ctx context.Context, svcCtx *svc.ServiceContext) *LoginLogic {
	return &LoginLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,    // 请求的上下文
		svcCtx: svcCtx, // 封装的操作对象
	}
}

// 登录逻辑处理的处理jwt的逻辑
func (l *LoginLogic) getJwtToken(secretKey string, iat, seconds, userId int64) (string, error) {
	claims := make(jwt.MapClaims)
	claims["exp"] = iat + seconds
	claims["iat"] = iat
	claims["userId"] = userId
	token := jwt.New(jwt.SigningMethodHS256)
	token.Claims = claims
	return token.SignedString([]byte(secretKey))
}

// 登录逻辑处理
func (l *LoginLogic) Login(req *types.LoginReq) (resp *types.LoginReply, err error) {

	if len(strings.TrimSpace(req.Username)) == 0 || len(strings.TrimSpace(req.Password)) == 0 {
		return nil, errors.New("参数错误")
	}
	userInfo, err := l.svcCtx.UserModel.FindOneByUserName(l.ctx, req.Username)

	switch err {
	case nil:
	case model.ErrNotFound:
		//return nil, errors.New(req.Username + "用户名不存在")
		return nil, errorx.NewCodeErrorResponse("用户名不存在")
	default:
		return nil, err
	}
	//比较查询的账号密码
	if userInfo.Password != req.Password {
		//return nil, errors.New("用户密码不正确")
		return nil, errorx.NewCodeErrorResponse("用户密码不正确")
	}
	//如果登录成功进行签名分发token
	now := time.Now().Unix()
	accessExpire := l.svcCtx.Config.Auth.AccessExpire
	//进行签名
	jwtTokenString, err := l.getJwtToken(l.svcCtx.Config.Auth.AccessSecret, now, accessExpire, userInfo.Id)

	if err != nil {
		return nil, err
	}

	return &types.LoginReply{
		Id:           userInfo.Id,
		Name:         userInfo.Name,
		Gender:       userInfo.Gender,
		AccessToken:  jwtTokenString,
		AccessExpire: now + accessExpire,
		RefreshAfter: now + accessExpire/2,
	}, nil
}

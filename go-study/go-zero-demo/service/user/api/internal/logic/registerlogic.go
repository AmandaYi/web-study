package logic

import (
	"book/service/user/api/internal/svc"
	"book/service/user/api/internal/types"
	"book/service/user/model"
	"context"
	"errors"
	"strings"

	"github.com/zeromicro/go-zero/core/logx"
)

type RegisterLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewRegisterLogic(ctx context.Context, svcCtx *svc.ServiceContext) *RegisterLogic {
	return &RegisterLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,
		svcCtx: svcCtx,
	}
}

func (l *RegisterLogic) Register(req *types.RegisterReq) (resp *types.RegisterResp, err error) {
	if len(strings.TrimSpace(req.Username)) == 0 || len(strings.TrimSpace(req.Password)) == 0 {
		return nil, errors.New("参数错误")
	}
	result, _ := l.svcCtx.UserModel.Insert(l.ctx, &model.User{
		Name:     req.Username,
		Password: req.Password,
	})
	userId, err := result.LastInsertId()
	if err != nil {
		return
	}

	return &types.RegisterResp{
		Id:       userId,
		Username: req.Username,
		Password: req.Password,
	}, nil
}

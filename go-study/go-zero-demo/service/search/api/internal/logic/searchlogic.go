package logic

import (
	"book/service/user/rpc/userclient"
	"context"
	"encoding/json"
	"fmt"

	"book/service/search/api/internal/svc"
	"book/service/search/api/internal/types"

	"github.com/zeromicro/go-zero/core/logx"
)

type SearchLogic struct {
	logx.Logger
	ctx    context.Context
	svcCtx *svc.ServiceContext
}

func NewSearchLogic(ctx context.Context, svcCtx *svc.ServiceContext) *SearchLogic {
	return &SearchLogic{
		Logger: logx.WithContext(ctx),
		ctx:    ctx,
		svcCtx: svcCtx,
	}
}

func (l *SearchLogic) Search(req *types.SearchReq) (resp *types.SearchReply, err error) {
	userIdNumber := json.Number(fmt.Sprintf("%v", l.ctx.Value("userId")))
	logx.Infof("userId: %s", userIdNumber)
	userId, err := userIdNumber.Int64()
	if err != nil {
		return nil, err
	}
	// rpc调用,serverContext已经依赖注入rpc服务
	_, err = l.svcCtx.UserRpc.GetUser(l.ctx, &userclient.IdReq{Id: userId})
	if err != nil {
		return nil, err
	}

	logx.Infof("userId: %v", l.ctx.Value("userId"))
	return &types.SearchReply{
		Name:  req.Name,
		Count: 100,
	}, nil

}

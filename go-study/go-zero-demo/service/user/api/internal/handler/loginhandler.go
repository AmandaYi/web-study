package handler

import (
	"net/http"

	"book/service/user/api/internal/logic"
	"book/service/user/api/internal/svc"
	"book/service/user/api/internal/types"
	"github.com/zeromicro/go-zero/rest/httpx"
)

// 登录方法的回调，这里一般是分发去调用各自的service方法
func loginHandler(svcCtx *svc.ServiceContext) http.HandlerFunc {
	return func(w http.ResponseWriter, r *http.Request) {

		var req types.LoginReq

		if err := httpx.Parse(r, &req); err != nil {
			httpx.ErrorCtx(r.Context(), w, err)
			return
		}
		//初始化一个登录的逻辑处理类，传入封装好的上下文对象，这里面有数据库操作对象，经过前面传递过来的
		//传递请求对象，传递封装当前需要的内容的封装对象
		//初始化一个LoginLogic结构体类
		l := logic.NewLoginLogic(r.Context(), svcCtx)

		//初始化登录逻辑类后，进行登录
		resp, err := l.Login(&req)
		if err != nil {
			httpx.ErrorCtx(r.Context(), w, err)
		} else {
			httpx.OkJsonCtx(r.Context(), w, resp)
		}
	}
}

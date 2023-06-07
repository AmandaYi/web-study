package svc

import (
	"book/service/search/api/internal/config"
	"book/service/search/api/internal/middleware"
	"book/service/user/rpc/types/user"
	"book/service/user/rpc/userclient"

	"github.com/zeromicro/go-zero/rest"
	"github.com/zeromicro/go-zero/zrpc"
)

type ServiceContext struct {
	Config  config.Config   // 依赖全部的内容，包括数据库的内容
	Example rest.Middleware // 把局部中间件依赖进来
	UserRpc user.UserClient
}

func NewServiceContext(c config.Config) *ServiceContext {
	return &ServiceContext{

		Config: c,

		Example: middleware.NewExampleMiddleware().Handle,

		UserRpc: userclient.NewUser(zrpc.MustNewClient(c.UserRpc)),
	}
}

/**

type AnotherService struct{}

func (s *AnotherService) GetToken() string {
	return stringx.Rand()
}

// 常规中间件
func middleware2(next http.HandlerFunc) http.HandlerFunc {
	return func(w http.ResponseWriter, r *http.Request) {
		w.Header().Add("X-Middleware", "static-middleware")
		next(w, r)
	}
}

// 调用其它服务的中间件
func middlewareWithAnotherService(s *AnotherService) rest.Middleware {
	return func(next http.HandlerFunc) http.HandlerFunc {
		return func(w http.ResponseWriter, r *http.Request) {
			w.Header().Add("X-Middleware", s.GetToken())
			next(w, r)
		}
	}
}
*/

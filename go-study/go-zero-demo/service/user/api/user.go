package main

import (
	"book/common/errorx"
	"book/service/user/api/internal/config"
	"book/service/user/api/internal/handler"
	"book/service/user/api/internal/svc"
	"context"
	"flag"
	"fmt"
	"github.com/zeromicro/go-zero/core/conf"
	"github.com/zeromicro/go-zero/rest"
	"github.com/zeromicro/go-zero/rest/httpx"
	"net/http"
)

var configFile = flag.String("f", "etc/user-api.yaml", "the config file")

// 入口
func main() {
	flag.Parse()

	var c config.Config
	conf.MustLoad(*configFile, &c)

	server := rest.MustNewServer(c.RestConf)
	defer server.Stop()
	//1 获取上下文，获取model操作模型
	ctx := svc.NewServiceContext(c)

	//2 注册路由，并把封装好的ctx传递进去【ctx含有model的user模型】
	//  执行路由注册，通过执行路由注册功能更，设置RestFul风格的路由
	//  在某个指定的路径下边，调用对应的路由处理函数，并把这里的ctx包装好的传递过去
	//  这里的server是监听控制器，传递进去为了使用服务启动方法等，主要使用的是server.AddRoutes方法给服务添加一个路由表
	handler.RegisterHandlers(server, ctx)

	// 自定义错误处理
	httpx.SetErrorHandlerCtx(func(ctx context.Context, err error) (int, any) {
		switch err := err.(type) {
		case *errorx.CodeError:
			return http.StatusOK, err.Data()
		default:
			return http.StatusInternalServerError, nil
		}
	})
	fmt.Printf("Starting server at %s:%d...\n", c.Host, c.Port)
	server.Start()
}

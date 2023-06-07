package svc

import (
	"book/service/user/api/internal/config"
	"book/service/user/model"
	"github.com/zeromicro/go-zero/core/stores/sqlx"
)

// 这里文件是依赖的意思，把需要的东西都堆到这里，方便后面的回调函数具体实现使用
type ServiceContext struct {
	Config    config.Config // 继承全部需要的配置项目用于每一个注册路由的使用
	UserModel model.UserModel
}

// 全局初始化，初始化全局上下文对象
// 变量返回的内容，可以上所有地方都使用
// 因此可以使用model的user，用于后面方便使用，相当于把数据库的user表的操作权限类传递过去了
func NewServiceContext(c config.Config) *ServiceContext {
	conn := sqlx.NewMysql(c.Mysql.DataSource)
	return &ServiceContext{
		Config:    c,
		UserModel: model.NewUserModel(conn, c.CacheRedis),
	}
}

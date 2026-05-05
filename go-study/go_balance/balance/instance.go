package balance

import "strconv"

// 创建一个结构体,用来保存,每一个服务器主机
type Instance struct {
	ip   string
	port int
}

// 对外暴露结构体,new 一个服务器中主机
func NewInstance(ip string, port int) *Instance {
	return &Instance{
		ip:   ip,
		port: port,
	}
}

// 得到主机的单项,ip
func (this *Instance) GetIP() string {
	return this.ip
}

// 得到主机的单项,port
func (this *Instance) GetPort() int {
	return this.port
}

//实现Prinf的string方法,用来格式化
func (this *Instance) String() string {
	return this.ip + ":" + strconv.Itoa(this.port)
}

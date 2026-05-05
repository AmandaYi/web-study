package balance

type Balancer interface {
	// 创建一个负载均衡
	DoBalance([]*Instance,...string)(*Instance,error)
}

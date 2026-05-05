package balance

import "errors"

// 注册一个列表,用来专门保存全部的负载均衡方法
type BalanceMgr struct {
	allBalancer map[string]Balancer
}

var mgr = BalanceMgr{
	allBalancer: make(map[string]Balancer),
}

// 初始化
func (this *BalanceMgr) registerBalancer(name string, b Balancer) {
	this.allBalancer[name] = b
}

func RegisterBalancer(name string, b Balancer) {
	mgr.registerBalancer(name, b)
}

func DoBalance(name string, insts []*Instance) (inst *Instance, err error) {
	balancer, ok := mgr.allBalancer[name]
	if !ok {
		err = errors.New("错误,未找到有效的调度方法")
		return
	}
	inst, err = balancer.DoBalance(insts)
	return
}

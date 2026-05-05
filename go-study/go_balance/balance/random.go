package balance

import (
	"errors"
	"math/rand"
)

// 创建一个随机算法
type RandomBalance struct {
}
// 自动注册自身算法
func init (){
	RegisterBalancer("random",&RandomBalance{})
}
// 用随机算法实现负载均衡接口的方法
func (this *RandomBalance) DoBalance(insts []*Instance, key ...string) (inst *Instance, err error) {
	// 看是否传入了insts
	if len(insts) == 0 {
		err = errors.New("未传入任何主机列表")
		return
	}
	// 随机数
	lens := len(insts)
	// 随机索引
	index := rand.Intn(lens)
	inst = insts[index]
	return
}

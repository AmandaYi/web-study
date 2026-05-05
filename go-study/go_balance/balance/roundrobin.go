package balance

import (
	"fmt"
)

// 创建一个负载均衡的方法,通过轮训算法
type RoundroBin struct {
	index int
}
// 自动注册自身算法
func init (){
	RegisterBalancer("round",&RandomBalance{})
}
// 实现负载均衡方法
func (this *RoundroBin) DoBalance(insts []*Instance, key ...string) (inst *Instance, err error) {
	if len(insts) == 0 {
		err = fmt.Errorf("错误,没有有效的主机列表")
		return
	}
	// // 判断状态
	// for ok!=true{

	// }
	if this.index >= len(insts) {
		this.index = 0
	}
	// 轮训算法,每次加一
	inst = insts[this.index]
	this.index++
	return
}

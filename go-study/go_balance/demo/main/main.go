package main

import (
	"math/rand"
	"os"
	"strconv"
	"time"

	"fmt"

	"github.com/amandayi/go/day7/balance/balance"
)

func main() {
	// 调用负载均衡调度器

	// 创建一个主机列表组
	var insts []*balance.Instance
	for i := 0; i < 16; i++ {
		ip := "192.168.1." + strconv.Itoa(rand.Intn(255))
		port := rand.Intn(255)
		insts = append(insts, balance.NewInstance(ip, port))
	}
	// 通过命令行参数,进行调度
	balanceName := "round"
	if len(os.Args) > 1 {
		balanceName = os.Args[1]
	}
	for {
		inst, err := balance.DoBalance(balanceName, insts)
		if err != nil {
			continue
		}
		fmt.Println(inst)
		time.Sleep(time.Second)
	}

}

void main() {}
// 定义混入对象
mixin BaseOrder {
  checkOrderStatus() {
    print("检查订单状态");
  }
}

// 可以混入一个新对象的功能
class UserOrder with BaseOrder {}

mixin Address {
  getAddressList() {
    print("获取全部地址列表");
  }
}

// 可以混入多个对象
class UserVipOrder with BaseOrder, Address {}

mixin VipOrder {
  checkOrderStatus() {
    print("检查订单状态，VIP的");
  }
}

// 混入继承，后一个的混入对象会覆盖前一个功能的，如VipOrder的checkOrderStatus会覆盖前一个BaseOrder的checkOrderStatus
class UserVipOrder2 with BaseOrder, VipOrder {}

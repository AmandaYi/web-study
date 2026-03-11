void main() {
  WeiXinPay wx = WeiXinPay();
  wx.pay();

  AliPay ali = AliPay();
  ali.pay();
}

abstract class BasePay {
  pay() {
    print("支付");
  }
}

class WeiXinPay extends BasePay {
  @override
  pay() {
    // TODO: implement pay

    print("微信支付");
  }
}

class AliPay implements BasePay {
  @override
  pay() {
    // TODO: implement pay

    print("支付宝支付");
  }
}

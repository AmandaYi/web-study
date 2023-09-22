import React from "react"
import { Provider, connect } from "react-redux"
import { store } from "./store"
import { getOrder, saveOrder } from "./action"


class OrderComponent extends React.Component {
    getOrderInfo = () => {
        this.props.saveOrder({
            id: 1,
            orderNo: 123456,
            productName: "笔记本"
        })
    }
    asyncGetOrderInfo = () => {
        this.props.getOrder(1)
    }
    render = () => {
        return (<>
            <p>id:{this.props.orderInfo.id}</p>
            <p>orderNo:{this.props.orderInfo.orderNo}</p>
            <p>productName:{this.props.orderInfo.productName}</p>
            <p onClick={this.getOrderInfo}>同步获取订单数据</p>
            <p onClick={this.asyncGetOrderInfo}>异步获取订单数据</p>
        </>)
    }
}

const WrapperOrder = connect((state) => {
    return {
        orderInfo: state.orderInfo
    }
}, (dispatch) => {
    return {
        saveOrder(info) {
            dispatch(saveOrder(info))
        },
        getOrder(id) {
            dispatch(getOrder(id))
        }
    }
})(OrderComponent)
export default class Index extends React.Component {
    render = () => {
        return (<><Provider store={store}>
            <WrapperOrder></WrapperOrder>
        </Provider></>)
    }
}
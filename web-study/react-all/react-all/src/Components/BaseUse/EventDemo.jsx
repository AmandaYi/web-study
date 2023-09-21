import React from "react"
export default class EventDemo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            name: "小明"
        }
        this.onClickHandler1 = this.onClickHandler1.bind(this)
    }
    onClickHandler1() {
        this.setState({
            name: "小张"
        })
    }
    // 静态方法this指向当前实例
    onClickHandler2 = () => {
        this.setState({
            name: "小张"
        })
    }
    // 获取Event()
    onClickHandler3 = (event) => {
        event.preventDefault()
        event.stopPropagation()

        console.log("target", event.target)
        console.log("currentTarget", event.currentTarget)
        // event 是React封装的，event.__proto__.constructor是SyntheticEvent组合事件
        console.log("event",event)
        console.log("event.__proto__.constructor", event.__proto__.constructor) // SyntheticEvent

        // 原生的event的原型构造函数event.__proto__.constructor是MouseEvent
        console.log("event.nativeEvent.__proto__.constructor",event.nativeEvent.__proto__.constructor)
        console.log("nativeEvent", event.nativeEvent)
        console.log("nativeEvent target", event.nativeEvent.target)
        console.log("nativeEvent current target",event.nativeEvent.currentTarget)
    }
    render = () => {
        return <p onClick={this.onClickHandler3}>
            {this.state.name}
        </p>
    }
}
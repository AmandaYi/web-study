import React from "react"

export default class SetStateCountDemo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            count: 0
        }
    }
    increase = () => {
        // 每次在有setState代码的函数体中，会先设置合并更新条件变量
        // isBatchingUpdates = true 
        this.setState({
            count: this.state.count + 1
        })
        // 在函数尾会把isBatchingUpdates = false
    }

    decrease = () => {
        this.setState({
            count: this.state.count - 1
        })
    }
    render = () => {
        return (<div>
            <button onClick={this.increase}>increase</button>
            <button onClick={this.decrease}>decrease</button>
        </div>)
    }
}
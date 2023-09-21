import React from "react"

export default class SetState extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            count: 0
        }
    }
    // componentDidMount = () => {
    //     this.setState({ count: this.state.count + 1 })
    //     console.log(this.state.count)
    //     this.setState({ count: this.state.count + 1 })
    //     console.log(this.state.count)

    //     this.setState(prevState => ({ count: this.state.count + 1 }), () => {
    //         console.log(this.state.count)
    //     })

    //     setTimeout(() => {
    //         this.setState({ count: this.state.count + 1 })
    //         console.log(this.state.count)
    //     }, 0)
    //     setTimeout(() => {
    //         this.setState({ count: this.state.count + 1 })
    //         console.log(this.state.count)
    //     }, 0)
    // }

    increase = () => {
        // 传入对象，会被合并，执行结果只有一次，也就是+1
        // this.setState({
        //     count: this.state.count + 1
        // })
        // this.setState({
        //     count: this.state.count + 1
        // })
        // this.setState({
        //     count: this.state.count + 1
        // })
        // this.setState((prevState, props) => ({ count: prevState.count + 1 }), () => console.log(this.state.count))
        // this.setState((prevState, props) => ({ count: prevState.count + 1 }), () => console.log(this.state.count))
        // this.setState((prevState, props) => ({ count: prevState.count + 1 }), () => console.log(this.state.count))
        // setTimeout(() => {
        //     this.setState({
        //         count: this.state.count + 1
        //     })
        //     console.log(this.state.count)
        // })
        Promise.resolve(() => {
            this.setState({
                count: this.state.count + 1
            })
            console.log(this.state.count)
        })
    }
    listenerIncrease = () => {
        this.setState({
            count: this.state.count + 1
        })
        console.log(this.state.count)
    }
    componentDidMount = () => {
        window.addEventListener("click", this.listenerIncrease)
    }
    render = () => {
        // return (<p>count:{this.state.count}</p>)
        return <div>
            <p>{this.state.count}</p>
            <button onClick={this.increase}>累加</button>
        </div>
    }
}
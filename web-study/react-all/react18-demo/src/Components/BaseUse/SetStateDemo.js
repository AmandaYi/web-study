import React from "react"

export default class SetStateDemo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            count: 0
        }
    }
    componentDidMount() {
        this.setState({ count: this.state.count + 1 })
        console.log(this.state.count);
        this.setState({ count: this.state.count + 1 })
        console.log(this.state.count)
        setTimeout(() => {
            this.setState({ count: this.state.count })
            console.log(this.state.count)
        })
        console.log(this.state.count)
    }

    increase = () => {
        this.setState({ count: this.state.count + 1 })
        console.log(this.state.count);
        this.setState({ count: this.state.count + 1 })
        console.log(this.state.count)
        setTimeout(() => {
            this.setState({ count: this.state.count })
            console.log(this.state.count)
        })
        console.log(this.state.count)
    }
    render = () => {
        const { count } = this.state
        return <div>
            <span>{count}</span>
            <button onClick={this.increase}>累加</button>
        </div>
    }
}
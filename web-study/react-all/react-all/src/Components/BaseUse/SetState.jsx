import React from "react"

export default class SetState extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            count: 0
        }
    }
    componentDidMount = () => {
        this.setState({ count: this.state.count + 1 })
        console.log(this.state.count)
        this.setState({ count: this.state.count + 1 })
        console.log(this.state.count)

        this.setState(prevState => ({ count: this.state.count + 1 }), () => {
            console.log(this.state.count)
        })

        setTimeout(() => {
            this.setState({ count: this.state.count + 1 })
            console.log(this.state.count)
        }, 0)
        setTimeout(() => {
            this.setState({ count: this.state.count + 1 })
            console.log(this.state.count)
        }, 0)
    }
    render = () => {
        return (<p>count:{this.state.count}</p>)
    }
}
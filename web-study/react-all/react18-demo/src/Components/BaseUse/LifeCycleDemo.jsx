import React from "react";
// LifeCycleDemo.getDerivedStateFromProps = () => {
//     console.log("getDerivedStateFromProps")
// }
export default class LifeCycleDemo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            count: 0
        }
    }
    getSnapshotBeforeUpdate = () => {
        console.log("getSnapshotBeforeUpdate")
        return 1
    }
    componentDidUpdate = (prevProps, prevState, snapshotReturnValue) => {
        console.log("componentDidUpdate")
        console.log("snapshotReturnValue",snapshotReturnValue)
    }
    componentDidMount = () => {
        console.log("componentDidMount")
    }
    addCount = () => {
        console.log("addCount")
        this.setState({
            count: this.state.count + 1
        })
    }
    render = () => {
        const { count } = this.state
        return (<>
            <div>LifeCycleDemo</div>
            <div>{count}</div>
            <div onClick={this.addCount}>增加</div>
        </>)
    }
}
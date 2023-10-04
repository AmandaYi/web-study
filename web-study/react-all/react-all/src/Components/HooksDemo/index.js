import React from "react";
import UseStateDemo from "./UseStateDemo"

export default class IndexHooksDemo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            display: true
        }
    }
    render = () => {
        const { display } = this.state
        return (
            <>
                <button onClick={() => { this.setState({ display: !display }) }}>切换组件</button>
                <hr />
                {display && <UseStateDemo />}
            </>
        )
    }
}
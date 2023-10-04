import React from "react";
import UseStateDemo from "./UseStateDemo"
import UseRefDemo from "./UseRefDemo";
import UseContextDemo from "./UseContextDemo";
import UseReducerDemo from "./UseReducerDemo";
import UseMemoDemo from "./UseMemoDemo";
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
                {/* {display && <UseStateDemo />} */}
                {/* <UseRefDemo/> */}
                {/* <UseContextDemo/> */}
                {/* <UseReducerDemo/> */}
                <UseMemoDemo/>
            </>
        )
    }
}
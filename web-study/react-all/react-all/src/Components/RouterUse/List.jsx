import React from "react";
import { Link } from "react-router-dom"
import { createBrowserHistory } from "history";
const history = createBrowserHistory();

export default class List extends React.Component {
    constructor(props) {
        super(props)
    }
    pushDetailView = () => {
        history.push("/detail/2")
    }
    render = () => {
        return (<>
            <p><Link to={"/detail/1"}>使用标签Link查看详情</Link></p>
            <p onClick={this.pushDetailView}>使用函数查看详情</p>
        </>)
    }
}
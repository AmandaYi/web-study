import React from "react";
import ReactDOM from "react-dom";
export default class PortalsDemo extends React.Component {
    render = ()=>{
        return <>{ReactDOM.createPortal(<div>Modal</div>, document.getElementsByTagName("body")[0])}</>
    }
}
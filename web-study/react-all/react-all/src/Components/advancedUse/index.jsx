import React from "react";
import ContextDemo from "./ContextDemo"
import AsyncDemo from "./AsyncDemo";
import HOCDemo from "./HOCDemo";
import HOCWithMouse from "./HOCWithMouse";
export default class Index extends React.Component {
    render = () => {
        return (<>
            {/* <ContextDemo></ContextDemo> */}
            {/* <AsyncDemo></AsyncDemo> */}
            {/* <HOCDemo></HOCDemo> */}
            <HOCWithMouse></HOCWithMouse>
        </>)
    }
}
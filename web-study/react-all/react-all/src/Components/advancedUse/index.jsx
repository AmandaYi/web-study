import React from "react";
import ContextDemo from "./ContextDemo"
import AsyncDemo from "./AsyncDemo";
export default class Index extends React.Component {
    render = () => {
        return (<>
            {/* <ContextDemo></ContextDemo> */}
            <AsyncDemo></AsyncDemo>
        </>)
    }
}
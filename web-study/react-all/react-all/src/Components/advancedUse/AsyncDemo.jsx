import React from "react";

const AsyncChildren = React.lazy(() => import("./AsyncChildren"))

export default class AsyncDemo extends React.Component {
    constructor(props) {
        super(props)
    }
    render = () => {
        return (<>
            <React.Suspense fallback={<>Loading</>}>
                <AsyncChildren></AsyncChildren>
            </React.Suspense></>)
    }
}
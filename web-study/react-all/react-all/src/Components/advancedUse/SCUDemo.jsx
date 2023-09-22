import React from "react";

export default class SCUDemo extends React.PureComponent {
    render = () => {
        return (<></>)
    }
}
function List() { }
function eqListState(prevProps, nextProps) {
    return true
}
const MemoList = React.memo(List, eqListState) 

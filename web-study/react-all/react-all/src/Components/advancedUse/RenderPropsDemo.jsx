import React from "react"

function ShowText(){
    return (<>ShowText</>)
}
function WrapperShowText (props){
    return (<>{props.render()}</>)
}

export default class RenderPropsDemo extends React.Component {
    render = () => {
        return (<><WrapperShowText render={ShowText}/></>)
    }
}
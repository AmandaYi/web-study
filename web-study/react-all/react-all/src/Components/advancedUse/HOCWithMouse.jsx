import React from "react";

const WithMouse = (Component) => {
    class HOC extends React.Component {

        constructor(props) {
            super(props)
            this.state = {
                mouseInfo: {
                    x: 0,
                    y: 0
                }
            }
        }
        onChangMouseInfo = (e) => {
            let x = e.pageX
            let y = e.pageY
            let mouseInfo = { x, y }
            this.setState({
                mouseInfo
            })
        }
        componentDidMount = () => {
            window.addEventListener("mousemove", this.onChangMouseInfo)
        }

        render = () => {
            return (<Component {...this.props} mouseInfo={this.state.mouseInfo}></Component>)
        }
    }
    return HOC
}
function ShowMouseXY(props) {
    return (<>x: {props.mouseInfo.x} y: {props.mouseInfo.y}</>)
}

const HOCWithMouse = WithMouse(ShowMouseXY)
export default HOCWithMouse
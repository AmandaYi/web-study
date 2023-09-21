import React from "react"

export default class ConditionDemo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            theme: "black"
        }
    }
    render = () => {
        const blackBtn = <button className="btn-black">btn-black</button>
        const whiteBtn = <button className="btn-white">btn-white</button>
        // if (this.state.theme === "black") {
        //     return blackBtn
        // } else {
        //     return whiteBtn
        // }
        // 三元运算符
        // return <>{this.state.theme === "black" ? blackBtn : whiteBtn}</>
        // &&
        return <>{this.state.theme === "black" && blackBtn}</>
    }
}
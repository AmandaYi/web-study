import React from "react";

export default class JSXBaseDemo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            name: "小明",
            flag: true
        }
    }

    render = () => {
        // 变量
        // const pElem = <p>{this.state.name}</p>
        // return pElem

        // 表达式
        // const exprElem = <p>{this.state.flag ? 'yes' : 'no'}</p>
        // return exprElem

        // className
        // const classElem = <p className="title">设置 css class</p>
        // return classElem

        // style
        // const styleData = { fontSize: "30px", color: "blue" }
        // const styleElem = <p style={styleData}>设置Data</p>
        // return styleElem

        // 原生HTML
        const rawHtml = `<span>文本</span>`
        const htmlElem = <p dangerouslySetInnerHTML={{ __html: rawHtml }}></p>
        return htmlElem
    }
}
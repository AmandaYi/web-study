import * as React from "react"

class Hello extends React.Component {
    constructor(props) {
        super(props)

    }
    render() {
        return (<div>{"我是React进行渲染的,Hill"}
            <div>666</div>
            <div>666</div>
            <div>666</div>
            <div>666</div>
            <div>666</div>
            <div>666</div>
            <div>666</div>
        </div>)
    }
}
class Hello2 extends React.Component {
    constructor(props) {
        super(props)

    }
    render() {
        return (<div>{"我是React进行渲染的,2"}
            <div>2</div>
            <div>2</div>
            <div>2</div>
            <div>2</div>
            <div>2</div>
            <div>2</div>
            <div>2</div>
        </div>)
    }
}

// 需要一个模板页面

export default Hello
export { Hello2 }
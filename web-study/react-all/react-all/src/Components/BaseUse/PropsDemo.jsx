import React from "react";
class Input extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            name: ""
        }
    }
    onChangeName = (e) => {
        this.setState({
            name: e.target.value
        })

    }
    onAdd = () => {
        this.props.onAdd(this.state.name)
        this.setState({
            name: ""
        })
    }
    render = () => {
        return (<>
            <input type="text" value={this.state.name} onChange={this.onChangeName} />
            <button onClick={this.onAdd}>增加</button>
        </>)
    }
}
class List extends React.Component {

    render = () => {
        return (<>
            {this.props.todoList.map(item => {
                return (<p key={(item + "").toString()}>{item}</p>)
            })}
        </>)
    }
}

export default class PropsDemo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            todoList: []
        }
    }
    onAdd = (v) => {
        this.setState({
            todoList: [...this.state.todoList, v]
        })
    }
    render = () => {
        return (<>
            <Input onAdd={this.onAdd}></Input>
            <List todoList={this.state.todoList}></List>
            <Footer></Footer>
        </>)
    }
}
// 验证SCU
class Footer extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            text: "footer"
        }
    }
    shouldComponentUpdate = (nextProps, nextState) => {
        if (nextState.text !== this.state.text) {
            return true
        } else {
            return false
        }
    }
    render = () => {
        console.log("footer 渲染")
        return (<>{this.state.text}</>)
    }
}
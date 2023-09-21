import React from "react";
export default class FormDemo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            name: "",
            content: "",
            sourceLevel: "A",
            date: ""
        }
    }
    onChangeName = (event) => {
        this.setState({
            name: event.target.value
        })
    }
    onChangeTexterea = (event) => {
        this.setState({
            content: event.target.value
        })
    }
    onChangeSourceLevel = (event) => {
        this.setState({
            sourceLevel: event.target.value
        })
    }
    onChangeDate = (event) => {
        this.setState({
            date: event.target.value
        })
    }

    render = () => {
        return (<>
            <form>
                <p> 姓名:
                    <input type="text" id="name" value={this.state.name} onChange={this.onChangeName} />
                    <label htmlFor={"name"}></label>{this.state.name}
                </p>
                <p>
                    签名:
                    <textarea value={this.state.content} id="content" onChange={this.onChangeTexterea}></textarea>
                    <label htmlFor={"content"}></label>{this.state.content}
                </p>
                <p>成绩等级：
                    <select value={this.state.sourceLevel} onChange={this.onChangeSourceLevel}>
                        <option value="A" label="优秀"></option>
                        <option value="B" label="良好"></option>
                        <option value="C" label="一般"></option>
                    </select>
                    <label htmlFor={"sourceLevel"}></label>{this.state.sourceLevel}
                </p>
                <p>
                    日期
                    <input type="checkbox" checked={this.state.date} onChange={this.onChangeDate} />
                    世界
                    <input type="radio" />
                </p>
            </form>
        </>)
    }
}
import React from "react"
export default class ListDemo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            list: [
                { id: 0, name: "1" },
                { id: 1, name: "2" },
                { id: 2, name: "3" }
            ]
        }
    }
    render = () => {
        return (<>{this.state.list.map(item => {
            return (<p key={item.id}>{item.name}</p>)
        })}</>)
    }
} 
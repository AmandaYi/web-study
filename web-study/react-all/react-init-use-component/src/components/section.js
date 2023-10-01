import React , { Component } from "react"
class Section extends Component {
    constructor(props) {
        super(props)
        this.state = {

        }
    }
    render=()=>{
        return(<li>
            {this.props.name}
        </li>)
    }
}
export default Section
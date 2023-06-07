import React from "react"
export default class PersonB extends React.Component {
    componentDidMount() {
        console.log(this.props)
    }
    render() {
        let title = this.props.match.params.title
        return (
            <div>
                <div>CCC PAGE</div>
                <div>标题:{title}</div>
            </div>
        )
    }
}
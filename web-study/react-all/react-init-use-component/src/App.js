import React, { Component } from "react"
import Section from "./components/section"


class App extends Component {
    constructor(props) {
        super(props)
        this.state = {
            names: [
                { name: "Tom", key: 0 },
                { name: "Jack", key: 1 },
                { name: "Jerry", key: 2 }
            ]
        }
    }
    render = () => {
        return (<div>
            <ul>
                {this.state.names.map((item) => {
                    return <Section name={item.name} key={item.key} />
                })}
            </ul>
            <button onClick={this.push}>change</button>
        </div>)
    }

    push=()=> {
        let names = this.state.names
        names.push({ name: "Kyle", key: names[names.length - 1].key + 1 })
        this.setState({
            names
        })
    }
}
export default App
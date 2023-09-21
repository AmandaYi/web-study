import React from "react"

// 创建一个context
const ThemeContext = React.createContext("black")

function ThemeButton(props) {
    return <><ThemeContext.Consumer>
        {value => <span>ThemeButton theme is {value}</span>}
    </ThemeContext.Consumer></>
}
ThemeButton.context = ThemeContext

class ThemeLink extends React.Component {
    constructor(props) {
        super(props)

    }
    render = () => {
        return <>ThemeLink theme is {this.context}</>
    }
}
// 这里其实就是类的静态属性，其实可以放到类里面设置static即可
ThemeLink.contextType = ThemeContext

export default class ContextDemo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            theme: "black"
        }
    }
    onChangeTheme = () => {
        let theme = this.state.theme === "black" ? "whait" : "black"
        this.setState({ theme })
    }
    render = () => {
        return <>
            <ThemeContext.Provider value={this.state.theme}>
                <ThemeButton></ThemeButton>
                <ThemeLink></ThemeLink>
                <button onClick={this.onChangeTheme}>改变主题</button>
            </ThemeContext.Provider>
        </>
    }
}
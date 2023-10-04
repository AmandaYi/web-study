import React, { useEffect, useRef, useContext, useState } from "react"

let themeConfig = {
    black: {
        color: "#fff"
    },
    white: {
        color: "#222"
    }
}
let ThemeContext = React.createContext(themeConfig.black)

function UseContextDemo() {
    let [config, setConfig] = useState(themeConfig.black)
    return (<>
        <ThemeContext.Provider value={config}>
            <Child />
            <button onClick={() => { setConfig({...themeConfig.white}) }}>改变主题</button>
        </ThemeContext.Provider>
    </>)
}
function Child() {
    let config = useContext(ThemeContext)
    return (<>
        <div>{JSON.stringify(config)}</div>
    </>)
}
export default UseContextDemo
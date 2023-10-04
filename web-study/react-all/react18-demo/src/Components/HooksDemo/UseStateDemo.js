import React, { useState } from "react"

function UseStateDemo(props) {
    let [count, setCount] = useState(0)

    function increase() {
        setCount(count + 1)
        console.log(count)  // 0
        setCount(count + 1)
        console.log(count) // 0
        setTimeout(() => {
            setCount(count + 1)
            console.log(count) // 2
        })
        console.log(count) // 0
    }

    return (<>
        <div>{count}</div>
        <button onClick={increase}>累加</button>
    </>)
}
export default UseStateDemo
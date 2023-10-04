import React, { useEffect, useState } from "react"

function UseStateDemo(props) {
    let [count, setCount] = useState(0)

    function increase() {
        setCount(count + 1)
        console.log(count)  // 0
        setCount(count + 1)
        console.log(count) // 0
        setTimeout(() => {
            setCount(count + 1)
            console.log(count) // 0
        }, 0)
        console.log(count) // 0
    }
    function mousePosition(e) {
        const x = e.clientX
        const y = e.clientY
        console.log(x, y)
    }
    // 模拟DidMount和DidUpdate
    useEffect(() => {
        console.log("did开始")
        // 返回的这个并不完全等于WillUnMount
        // 因为，每次props变化后，更新时，会先执行上次的return的函数，
        // 即，返回的函数，会在下一次的更新时执行一次
        return () => {
            console.log("结束")
        }
    })
    // 模拟DidMount
    useEffect(() => {

    }, [])
    // 模拟DidUpdate
    useEffect(() => {

    }, [count])
    // 模拟WillUnMount，在return中返回函数即可
    useEffect(() => {
        return () => {

        }
    }, [])



    useEffect(() => {
        window.document.addEventListener("mousedown", mousePosition)
        return () => {
            window.document.removeEventListener("mousedown", mousePosition)
        }
    }, [])

    return (<>
        <div>{count}</div>
        <button onClick={increase}>累加React17.0.2</button>
    </>)
}
export default UseStateDemo
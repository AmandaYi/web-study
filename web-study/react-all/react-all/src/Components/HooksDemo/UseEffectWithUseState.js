import React, { useEffect, useRef, useState } from "react"

function UseEffectWithUseState1() {
    let [count, setCount] = useState(0)
    let countRef = useRef(0)
    useEffect(() => {
        console.log("didMount")
        setInterval(() => {
            console.log("setTimeout")
            // setCount(count + 1)
            setCount(++countRef.current)
        }, 1000)
    }, [])
    return (<>
        count: {count}
    </>)
}
function UseEffectWithUseState() {
    let [count, setCount] = useState(0)
    let config = {}
    let countRef = useRef(0)
    useEffect(() => {
        console.log("useEffect")
        setCount(++countRef.current)
    }, [count, config]) // config是{}，useEffect会使用Object.is进行比较
    return (<>
        count: {count}
    </>)
}
export default UseEffectWithUseState
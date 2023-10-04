import React, { memo, useCallback, useEffect, useState } from "react";
function Child1(props) {
    useEffect(() => {
        console.log("child1 update")
    })
    return (<>
        <button onClick={props.changeCount}>调用父组件方法changCount</button>
    </>)
}
function Child2(props) {
    useEffect(() => {
        console.log("child2 update")
    })
    return (<>
        <button onClick={props.changeName}>调用父组件方法changName</button>
    </>)
}
const Child1Memo = memo(Child1)
const Child2Memo = memo(Child2)
function UseCallbackDemo() {
    let [count, setCount] = useState(0)
    let [name, setName] = useState("小明")
    const changeCount = useCallback(() => {
        setCount(count + 1)
    }, [count])
    const changeName = useCallback(() => {
        setName(parseInt(Math.random() * 10))
    }, [name])
    return (
        <>
            count: {count}
            name: {name}
            <Child1Memo changeCount={changeCount} />
            <Child2Memo changeName={changeName} />
        </>
    )
}
export default UseCallbackDemo
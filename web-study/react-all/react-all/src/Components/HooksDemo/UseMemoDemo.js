import React, { useMemo, useState } from "react";
function UseMemoDemo() {
    let [count, setCount] = useState(0)
    let [name, setName] = useState("小明")

    let info = useMemo(() => {
        return { count, name }
    }, [count])
    return (<>
        <div>
            count:{count}
            <button onClick={() => setCount(count + 1)}>累加</button>
            info: {JSON.stringify(info)}
            count:{name}
            <button onClick={() => setName("小张")}>改变name,info里面的name不会改变</button>
        </div>
    </>)
}
export default UseMemoDemo
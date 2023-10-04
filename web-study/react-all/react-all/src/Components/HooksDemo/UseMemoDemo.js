import React, { useState } from "react";
function UseMemoDemo() {
    let [count, setCount] = useState(0)
    return (<>
        <div>
            count:{count}
            <button onClick={() => setCount(count + 1)}>累加</button>
        </div>
    </>)
}
export default UseMemoDemo
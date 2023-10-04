import React, { useEffect, useRef } from "react"
function UseRefDemo() {
    let btnRef = useRef(null)
    useEffect(() => {
        console.log(btnRef);
    }, [])
    return (<>
        <button ref={btnRef}>save</button>
    </>)
}
export default UseRefDemo
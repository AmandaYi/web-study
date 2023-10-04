import React, { useEffect, useState } from "react";

function useMousePosition() {
    let [x, setX] = useState(0)
    let [y, setY] = useState(0)
    function mouseUpdate(e) {
        setX(e.clientX)
        setY(e.clientY)
    }
    useEffect(() => {
        window.document.addEventListener("mousemove", mouseUpdate)
        return () => {
            window.document.removeEventListener("mousemove", mouseUpdate)
        }
    }, [])
    return [x, y]
}
function CustomHookDemo() {
    const [x, y] = useMousePosition()
    return (<>
        x: {x}
        y: {y}
    </>)
}
export default CustomHookDemo
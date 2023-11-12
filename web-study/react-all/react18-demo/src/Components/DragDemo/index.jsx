import React, { useEffect } from "react";


function LeftOp() {
    function onDropStart() {
        console.log("start")
    }
    useEffect(() => {
        let drapH3 = document.getElementById("drapH3")
        drapH3.ondragstart = (e) => {
            e.dataTransfer.effectAllowed = "move"
            console.log("start")
        }
        drapH3.ondragover = (e) => {
            e.preventDefault()
            console.log("e", e)
        }
        drapH3.ondragenter = (e) => {
            // e.preventDefault()
            console.log("enter", e)
        }
        drapH3.ondrop = (e) => {
            console.log("drop", e)
        }
        let box = document.getElementById("box")
        box.ondragover = (e) => {
            e.preventDefault()
        }
    }, [])

    return <>
        <div>
            <h3 id="drapH3" draggable={true}>移动文本</h3>
        </div></>
}

function Box() {
    const style = {
        height: "500px",
        width: "500px",
        backgroundColor: "#ccc"
    }
    return <>
        <div style={style} id="box" draggable={true}>

        </div>
    </>
}
export default function Index() {
    return (<>
        <div>
            <LeftOp></LeftOp>
            <Box></Box>
        </div>
    </>)
}
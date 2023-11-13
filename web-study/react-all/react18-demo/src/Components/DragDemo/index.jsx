import React, { useEffect, useRef, useState } from "react";

function LeftOp(props) {
    function onDragStart(event) {
        props.opDragStart(event)
    }
    return <>
        <span draggable={true} onDragStart={onDragStart}>移动文本</span>
    </>
}

function Box(props) {
    function onDragOver(e) {
        e.preventDefault()
    }
    // ondrop事件始终不触发，原因是没有定义ondragover事件，
    // ondragover事件是被拖拽元素在目标元素上拖拽过程中由目标元素触发，
    // 需要取消掉它的默认事件(e.preventDefault())才可以正确触发，
    // ondrop事件是被拖拽元素在目标元素上面drop的时候由[目标元素]触发;
    function onDrop(event) {
        props.boxDrop(event)
    }

    function onDragStart(event) {
        props.opDragStart(event)
    }
    const style = {
        position: "relative",
        height: "500px",
        width: "500px",
        backgroundColor: "#ccc"
    }
    let dragItemList = props.dragItemList || []

    return <>
        <div style={style} onDrop={onDrop} onDragOver={onDragOver} >
            {dragItemList && dragItemList.map((item, index) => {
                // return <span draggable={true} onDragStart={onDragStart} key={"boxDragItem" + index}>移动文本</h3>
                return (<>
                    <span style={item.style} draggable={true} onDragStart={onDragStart}>{item.data.name}</span>
                </>)
            })}
        </div>
    </>
}
export default function Index() {
    // 状态提升

    let [dragItemList, setDragItemList] = useState([])

    function opDragStart(event) {
        console.log("opDragStart", event)
        event.dataTransfer.effectAllowed = "move"

    }
    function boxDrop(event) {
        console.log("boxDrop", event)
        let tmpList = dragItemList.concat({
            style: {
                position: "absolute",

                left: event.nativeEvent.offsetX,
                top: event.nativeEvent.offsetY,
            },
            font: {
                size: "",
            },
            data: {
                name: "默认文本"
            }
        })
        setDragItemList(tmpList)
    }
    return (<>
        <div>
            <LeftOp opDragStart={opDragStart}></LeftOp>
            <Box dragItemList={dragItemList} boxDrop={boxDrop} opDragStart={opDragStart}></Box>
        </div>
    </>)
}
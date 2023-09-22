import React from "react";

// 高阶组件是一种工厂模式
const HOCFactory = (Component) => {
    class HOC extends React.Component {
        // 在这里定义公用的逻辑
        render = () => {
            return (<><Component {...this.props}></Component></>)
        }
    }
    return HOC
}

function ShowText() {
    return (<>showText</>)
}

const HOCDemo = HOCFactory(ShowText)
export default HOCDemo


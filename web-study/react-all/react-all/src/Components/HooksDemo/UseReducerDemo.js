import React, { useReducer } from "react";


function reducer(state = {
    count: 0
}, action) {
    switch (action.type) {
        case "increase": {
            return {
                ...state,
                count: state.count + 1
            }
        }
        case "decrease": {
            return {
                ...state,
                count: state.count - 1
            }
        }
        default: {
            return {}
        }
    }
}

function UseReducerDemo() {
    let [state, dispatch] = useReducer(reducer, { count: 0 })
    return (<>
        {state.count}
        <button onClick={() => { dispatch({ type: "increase" }) }}>累加</button>
        <button onClick={() => { dispatch({ type: "decrease" }) }}>累减</button>
    </>)

}
export default UseReducerDemo
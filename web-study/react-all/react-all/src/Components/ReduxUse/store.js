import { createStore, applyMiddleware } from "redux"
import thunk from 'redux-thunk'
import { reducer } from "./reducer"
const store = createStore(reducer, applyMiddleware(thunk))
// 中间件实现逻辑
let oldDispatch = store.dispatch
store.dispatch = function (action) {
    console.log("监听redux执行STR", action)
    oldDispatch(action)
    console.log("监听redux执行END", action)
}
export { store }
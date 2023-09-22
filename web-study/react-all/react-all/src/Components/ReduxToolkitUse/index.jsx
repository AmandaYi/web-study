import React from "react";
import { Provider, connect } from "react-redux"
import { store } from "./store/store";

class OrderComponent extends React.Component {

    render = () => {
        return <>
        </>
    }
}
const WrapperOrder = connect()(OrderComponent)
export default class IndexRedux extends React.Component {
    render = () => {
        return (<Provider store={store}>
            <WrapperOrder></WrapperOrder>
        </Provider>)
    }
}
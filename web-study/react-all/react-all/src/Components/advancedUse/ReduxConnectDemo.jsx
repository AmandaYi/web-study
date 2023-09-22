import React from "react";

export default connect = (mapStateToProps, mapDispatchToProps) => (WrappedComponent) => {
    class Connect extends React.Component {
        render = () => {
            return (<WrappedComponent {...this.props} {...this.state}></WrappedComponent>)
        }
    }
    return Connect
}
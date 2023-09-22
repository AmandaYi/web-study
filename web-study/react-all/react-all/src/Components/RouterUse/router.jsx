import React from "react"
import { HashRouter as Router, Switch, Route } from "react-router-dom"
import List from "./List"
import Detail from "./detail"
function RouterComponent() {
    return (
        <Router>
            <Switch>
                <Route exact path="/">
                    <List />
                </Route>
                <Route path="/detail/:id">
                    <Detail />
                </Route>
            </Switch>
        </Router>
    )
}
export default RouterComponent
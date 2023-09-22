import React, { Suspense } from "react"
import { HashRouter as Router, Switch, Route } from "react-router-dom"
import List from "./List"
const Detail = React.lazy(() => import("./detail"))
function RouterComponent() {
    return (
        <Router>
            <Suspense fallback={"Loading"}>
                <Switch>
                    <Route exact path="/">
                        <List />
                    </Route>
                    <Route path="/detail/:id">
                        <Detail />
                    </Route>
                </Switch>
            </Suspense>
        </Router>
    )
}
export default RouterComponent
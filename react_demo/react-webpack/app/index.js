import React from "react"
import ReactDOM from "react-dom"






import Person from "./person"
import PersonA from "./persona"
import PersonB from "./personb"

import { Route, BrowserRouter as Router } from "react-router-dom"
ReactDOM.render(

    <Router>
        <div>
            <Route exact path="/" component={Person}></Route>
            <Route path="/a" component={PersonA}></Route>
            <Route path="/b" component={PersonB}></Route>
        </div>
    </Router>




    , document.getElementById("app"))
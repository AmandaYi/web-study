import React from "react"
import ReactDOM from "react-dom"






import Person from "./person"
import PersonA from "./persona"
import PersonB from "./personb"
import PersonC from "./personc"

import { Route, BrowserRouter as Router, Switch ,Redirect } from "react-router-dom"


// 引入导航
import { NavBar } from "./nav"
// 引入404
import Err from "./err"
ReactDOM.render(

    <Router  >

        <div>
            <NavBar></NavBar>
            <Switch>
                <Route exact path="/" component={Person}></Route>
                <Route path="/persona" component={PersonA}></Route>
                <Route path="/personb" component={PersonB}></Route>
                <Route path="/personc/:title" component={PersonC}></Route>
                <Redirect from="/reset" to="/persona"/>
                <Route component={Err} />
            </Switch>
        </div>
    </Router>




    , document.getElementById("app"))
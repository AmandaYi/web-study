import React from "react"
import {NavLink} from "react-router-dom"
import "./nav.css"
export const NavBar = ()=>{
    return (
        <div>
            <div>
                <NavLink className="blue" exact to="/" activeClassName="yellow">首页&nbsp;</NavLink>
                <NavLink to="/persona" className="blue" activeClassName="yellow">persona&nbsp;</NavLink>
                <NavLink to="/personb" className="blue" activeClassName="yellow">personb&nbsp;</NavLink>
                <NavLink to="/personc/小明你好" className="blue" activeClassName="yellow">personc&nbsp;</NavLink>
                <NavLink to="/errrr" className="blue" activeClassName="yellow">随便page&nbsp;</NavLink>
                <NavLink to="/reset" className="blue" activeClassName="yellow">reset跳转到AAAA页面&nbsp;</NavLink>
            </div>
        </div>
    )
}
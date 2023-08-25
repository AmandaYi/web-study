const Koa = require("koa")
const Static = require("koa-static")


const path = require("path")
const app =new Koa()


app
.use(Static(__dirname))
.listen(3000,()=>console.log("server at 3000"))
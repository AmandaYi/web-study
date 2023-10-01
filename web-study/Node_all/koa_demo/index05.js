const Koa = require("koa")
const app = new Koa()
const bodyParser = require('koa-bodyparser');
app.use(bodyParser());
const port = 8000
app.use(async (ctx) => {
    let url = ctx.url
    let method = ctx.method
    if (url == "/" && method.toLocaleLowerCase() == "get") {
        let template = `
        <h1>填写表单</h1>
            <form method="POST"  action="/">
                <p>用户名</p>
                <input name="userName" /> <br/>
                <p>年龄</p>
                <input name="age" /> <br/>
                <p>网站站点</p>
                <input name='webSite' /><br/>
            <button type="submit">submit</button>
        </form>`
        ctx.body = template
    } else if (url == "/" && method.toLocaleLowerCase() == "post") {
        ctx.body = ctx.request.body
    } else {
        ctx.body = "404"
    }
    // let req = ctx.request
    // let queryFromReq = req.query
    // let queryStringFromReq = req.querystring
    // let queryFromCtx = ctx.query
    // let queryStringFromCtx = ctx.querystring
    // let resBody = {
    //     url,
    //     queryFromReq,
    //     queryStringFromReq,
    //     queryFromCtx,
    //     queryStringFromCtx,
    // }
    // ctx.body=resBody
})
app.listen(port)

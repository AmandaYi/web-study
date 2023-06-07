const Koa = require("koa")
const app = new Koa()
const port = 8000
app.use(async (ctx) => {
    let url = ctx.url
    let req = ctx.request
    let queryFromReq = req.query
    let queryStringFromReq = req.querystring
    let queryFromCtx = ctx.query
    let queryStringFromCtx = ctx.querystring
    let resBody = {
        url,
        queryFromReq,
        queryStringFromReq,
        queryFromCtx,
        queryStringFromCtx,
    }
    ctx.body=resBody
})
app.listen(port)
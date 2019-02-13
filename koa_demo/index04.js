const Koa = require("koa")
const app = new Koa()
const port = 8000
function parsePostData(ctx) {
    return new Promise((resolve, reject) => {
        try {

            let postdata = "";
            ctx.req.on('data', (data) => {
                postdata += data
            })
            ctx.req.addListener("end", function () {
                resolve(postdata);
            })
        } catch (error) {
            reject(error);
        }
    });
}
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
        let pastData = await parsePostData(ctx); 
        let request = pastData 
        ctx.body = request
    } else {
        ctx.body = "404"
    }
})
app.listen(port)

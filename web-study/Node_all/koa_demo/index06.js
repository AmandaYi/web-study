const Koa = require("koa")
const app = new Koa()

const port = 8000


const fs = require("fs")
// 渲染html
function renderHtml(page) {

    return new Promise((resolve, reject) => {
        fs.readFile("./public/" + page, "utf8", (err, data) => {

            if (err) {
                reject(data)
            } else {
                resolve(data)
            }

        })

    })



}

async function route(url) {
    if (!url) {
        return
    }

    let page = "index"
    switch (url) {
        case "/home":
            page = "home.html"
            break;
        case "/login":
            page = "login.html";
            break
        case "/register":
            page = "register.html"
            break
        default:
            page = "404.html";

    }
    return await renderHtml(page)
}






app.use(async (ctx) => {
    let url = ctx.url
    ctx.body =await route(url)


})
app.listen(port)
console.log('starting at '+port);

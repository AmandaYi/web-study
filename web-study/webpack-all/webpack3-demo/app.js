const express= require("express")
const app = express()
app.listen(2019)
app.use(express.static("./dist/"))
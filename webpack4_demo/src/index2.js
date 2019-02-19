window.onload = function () {
    let title = document.getElementById("title")
    title.innerHTML = "多页面配置的第二个页面,2秒后自动改变!"
    setTimeout(() => {
        title.innerHTML = "我改变了!"
     }, 2000)
}

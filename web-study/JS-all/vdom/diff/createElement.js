// patch(box,vnode) 
// 初次渲染的时候的逻辑
function createElement(vnode) {
    // 获取标签
    var tag = vnode.tag
    // 获取属性
    var attr = vnode.attr || {}
    // 获取子元素
    var children = vnode.children || []

    // 创建一个标签
    var elem = document.createElement(tag)
    // 进行设置属性
    var key
    for (key in attr) {
        if (attr.hasOwnProperty(key)) {
            elem.setAttribute(key, attr[key])
        }
    }
    // 追加子元素
    children.forEach(item => {
        elem.appendChild(createElement(item))
    });
    // 返回创建的元素
    return elem
}
// 最后的整体是返回的是第一次进入函数创建的elem
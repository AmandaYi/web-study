// patch(vnode,newvnode)
// 重新渲染的时候, 
function updateElement(vnode, newvnode) {
    var children = vnode.children || []
    var newChildren = newvnode.children || []
    // 进行循环对比,当发现,
    // 如果两个相等,那么直接递归往下对比
    newChildren.forEach((item, index) => {
        var tmp = children[index]
        if (item.tag === tmp.tag) {
            updateElement(tmp, item)
        } else {
            replaceElement(tmp, newChildren[index])
        }
    });
    // 如果不相等,那么替换
}




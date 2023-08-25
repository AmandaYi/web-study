<template>
    <div>
        <p>文本插值:{{ message }}</p>
        <p>JS表达式:{{ flag ? '是' : '不是' }}只能是表达式</p>
        <p :data-id="dynamicId">动态属性{{ dynamicId }}</p>
        <p v-html="rawHtml">
            <span>使用v-html后，会覆盖子标签</span>
        </p>
    </div>
</template>
<script>
export default {
    data() {
        return {
            message: "文本差值",
            flag: true,
            rawHtml: "指令 - 原始 html <b>加粗</b> <i>斜体</i>",
            dynamicId: `Id-${Date.now()}`,
        }
    }
}
</script>
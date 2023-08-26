<template>
    <div>
        <div :class="[infoNameStyle, isDark]">使用数组class</div>
        <div :class="{ isDark: isDark, infoNameStyle: !!infoNameStyle }">使用对象class</div>
        <div :style="infoNameStyle">使用style属性</div>
    </div>
</template>
<script>


export default {
    data() {
        return {
            isDark: true,

            infoNameStyle: {
                backgroundColor: "#fff"
            },
            darkStyle: {
                backgroundColor: "#000",
                color: "#fff"
            }

        }
    }
}
</script>
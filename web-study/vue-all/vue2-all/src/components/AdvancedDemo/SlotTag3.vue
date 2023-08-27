<template>
    <div>
        <slot name="default" :defaultProp="defaultProp"></slot>
    </div>
</template>
<script>
export default {
    data() {
        return {
            defaultProp: {
                name:"默认值"
            }
        }
    }
}
</script>
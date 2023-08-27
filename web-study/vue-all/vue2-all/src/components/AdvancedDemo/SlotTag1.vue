<template>
    <div>
        <h1>
            <slot name="default"></slot>
        </h1>
        <h2>
            <slot name="content"></slot>
        </h2>
    </div>
</template>
<script>

export default {
    data() {
        return {

        }
    }
}
</script>
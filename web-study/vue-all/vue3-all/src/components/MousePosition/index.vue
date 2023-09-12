<template>
    {{ x }} - {{ y }}
</template>
<script>
import useMousePosition from "./useMousePosition.js"
export default {
    setup() {
        const { x, y } = useMousePosition()
        return {
            x, y
        }
    }
}
</script>
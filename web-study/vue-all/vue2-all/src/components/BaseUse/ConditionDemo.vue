<template>
    <keep-alive>
        <div>
            <p v-if="name === 'z'">z</p>
            <p v-else>y1</p>
            <p v-else>y2</p>
            <p v-show="name === 'z'">zzz</p>
            <p @click="name = 'y'">设置name为y</p>
            <p @click="name = 'z'">设置name为z</p>
        </div>
    </keep-alive>
</template>
<script>
export default {
    data() {
        return {
            name: "z"
        }
    }
}
</script>

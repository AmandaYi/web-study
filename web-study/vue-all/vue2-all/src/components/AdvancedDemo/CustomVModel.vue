<template>
    <div>
        <input type="text" @input="changeInput">
        <p> backgroundColor: {{ backgroundColor }}</p>
        <p> value: {{ value }}</p>
    </div>
</template>
<script>
export default {
    model: {
        prop: "backgroundColor",
        event: "backgroundColorChange"
    },
    props: {
        backgroundColor: {
            type: String,
            default() {
                return ""
            }
        },
        value: {
            type: String,
            default() {
                return ""
            }
        }
    },
    data() {
        return {

        }
    },
    methods: {
        changeInput(event) {
            this.$emit('input', event.target.value)
            this.$emit('backgroundColorChange', event.target.value)
        }
    }
}
</script>
import { onBeforeMount, onMounted, reactive, toRefs } from "vue"

function useMounsePosition() {
    let state = reactive({
        x: 0,
        y: 0
    })
    function update(e) {
        state.x = e.pageX
        state.y = e.pageY
    }
    onMounted(() => {
        window.addEventListener("mousemove", update)
    })
    onBeforeMount(() => {
        window.removeEventListener("mousemove", update)
    })
    return toRefs(state)
}

export default useMounsePosition
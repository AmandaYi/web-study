<template>
    <div>
        {{ nameRef }} - {{ ageRef }}
    </div>
</template>
<script>
import { ref } from 'vue';

export default {
    setup() {
        let nameRef = ref("小明")
        let ageRef = ref(0)

        setTimeout(() => {
            nameRef.value = "小张"
        }, 1500);
        setTimeout(() => {
            ageRef.value = 20
        }, 3000);

        return {
            nameRef, ageRef
        }
    }
}
</script>
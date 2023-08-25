<template>
    <div>
        <p>数量: <input type="text" v-model="count"></p>
        <p>单价: <input type="text" v-model="price"></p>
        <p>总和计算属性：{{ sum }}</p>
        <div @click="updateComputedData">获取最低价{{ computedData }}</div>
        <div @click="updateComputedData2">获取最低价2{{ computedData }}</div>
        <div @click="updateComputedData3">获取最低价3{{ computedData }}</div>
    </div>
</template>
<script>
import { mapMutations, mapState } from "vuex"
export default {

    data() {
        return {
            count: 0,
            price: 0
        }
    },
    created() {

    },
    mounted() {

    },
    methods: {

        ...mapMutations("baseUse", {
            updateComputedData(commit) {
                let price = this.price
                commit("updateComputedData", price);
            }
        }),
        ...mapMutations({
            updateComputedData2(commit) {
                let price = this.price
                commit("baseUse/updateComputedData", price);
            }
        }),
        updateComputedData3() {
            let price = this.price
            this.$store.commit("baseUse/updateComputedData", price);
        }


    },
    computed: {
        ...mapState({
            computedData: state => state.baseUse.computedData
        }),
        sum() {
            return this.count * this.price
        }
    }
}
</script>
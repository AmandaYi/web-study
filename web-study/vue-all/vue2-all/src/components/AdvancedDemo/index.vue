<template>
    <div>
        <!-- <div :style="divStyle">
        <CustomVModel v-model="divStyle.backgroundColor"></CustomVModel>
    </div> -->

        <div>
            <!-- <SlotDemo></SlotDemo> -->
        </div>
        <!-- <div>
            <AsyncDemo></AsyncDemo>
        </div> -->

        <div>
            <MixinDemo></MixinDemo>
        </div>
    </div>
</template>
<script>
import CustomVModel from './CustomVModel.vue';
import SlotDemo from './SlotDemo.vue';
import AsyncDemo from './AsyncDemo.vue';
import MixinDemo from './MixinDemo.vue';
export default {
    components: {
    CustomVModel,
    SlotDemo,
    AsyncDemo,
    MixinDemo
},
    data() {
        return {
            divStyle: { backgroundColor: "", height: "50px" }
        }
    }
}
</script>
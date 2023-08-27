<template>
    <div>
        <!-- 父级模板里的所有内容都是在父级作用域中编译的；子模板里的所有内容都是在子作用域中编译的。 -->
        <SlotTag1>
            <template v-slot:default>title</template>
            <template v-slot:content>content</template>
        </SlotTag1>
        <!-- 具有默认值 -->
        <SlotTag2></SlotTag2>
        <!-- 使用插槽的值 -->
        <SlotTag3 v-slot:default="defaultProp">
            {{ defaultProp.defaultProp.name }}
        </SlotTag3>
    </div>
</template>
<script>
import SlotTag1 from './SlotTag1.vue';
import SlotTag2 from './SlotTag2.vue';
import SlotTag3 from './SlotTag3.vue';
export default {
    components: {
        SlotTag1,
        SlotTag2,
        SlotTag3
    },
    data() {
        return {


        }
    }
}
</script>
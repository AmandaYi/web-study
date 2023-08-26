<template>
    <div>
        <p>输入框</p>
        <input type="text" v-model.trim="name" />
        <input type="text" v-model.lazy="name" />
        <input type="text" v-model.number="age" />

        <p>多行文本：{{ desc }}</p>
        <textarea v-model="desc"></textarea>

        <p>复选框{{ checked }}</p>
        <input type="checkbox" id="a" v-model="checked" value="A">
        <label for="a">A</label>

        <p>多个复选框{{ checkedNames }}</p>
        <input type="checkbox" id="Jack" value="Jack" v-model="checkedNames" />
        <label for="jack">Jack</label>
        <input type="checkbox" id="John" value="John" v-model="checkedNames" />
        <label for="john">John</label>
        <input type="checkbox" id="Mike" value="Mike" v-model="checkedNames" />
        <label for="mike">Mike</label>

        <p>单选{{ gender }}</p>
        <input type="radio" id="male" value="male" v-model="gender" />
        <label for="male">男</label>
        <input type="radio" id="female" value="female" v-model="gender" />
        <label for="female">女</label>

        <p>下拉列表选择{{ selected }}</p>
        <select v-model="selected">
            <option disabled value="">请选择</option>
            <option value="a">A</option>
            <option value="b">B</option>
            <option value="c">C</option>
        </select>

        <p>下拉列表选择多选{{ selectedList }}</p>
        <select v-model="selectedList" multiple>
            <option disabled value="">请选择</option>
            <option value="a">A</option>
            <option value="b">B</option>
            <option value="c">C</option>
        </select>
    </div>
</template>
<script>
export default {
    data() {
        return {
            name: "",
            age: "",
            desc: "",
            checked: [],
            checkedNames: [],
            gender: "",
            selected: "",
            selectedList: []
        }
    }
}
</script>

<template>
    <div>
        <p>{{ count }}</p>
        <p @click="add">点我增加1</p>
        <p @click="add2(2, $event)">点我增加2</p>
        <div>
            <a v-on:click.stop="doThis">阻止单击事件继续传播</a>
            <form v-on:submit.prevent="onSubmit">提交事件不再重载页面</form>
            <a v-on:click.stop.prevent="doThat">修饰符可以串联</a>
            <form v-on:submit.prevent>只有修饰符</form>
            <div v-on:click.capture="doThis">添加事件监听器时使用事件捕获模式，即内部元素触发的事件先在此处处理，然后才交由内部元素自己处理</div>
            <div v-on:click.self="doThat">只当在event.target是自身元素才出发事件，即元素不是从内部冒泡触发的</div>
        </div>
        <div>
            <button @click.ctrl="onClick">即使alt或shift被一同按下时也会触发 </button>
            <button @click.ctrl.exact="onCtrlClick">有且只有Ctrl被按下时才触发</button>
            <button @click.exact="onClick">没有任何系统修饰符被按下的时候才触发</button>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            count: 0
        }
    },
    methods: {
        add(event) {
            this.count++
            console.log(event, "--", event.__proto__.constructor)
            console.log(event.currentTarget) // -> <p>点我增加1</p>
        },

        add2(n, event) {
            this.count += n
            console.log(event)
        }
    }
}
</script>
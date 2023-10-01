#include <stdio.h>
#include <malloc.h>

#define InitSize 10
//创销-增删改查
//动态分配
struct SeqList {
    int *data;
    int MaxSize;
    int length;
};

//初始化
void InitList(struct SeqList *p) {
    p->data = (int *) malloc(InitSize * sizeof(int));
    p->MaxSize = InitSize;
    p->length = 0;
};

//增加容量
void IncreaseSize(struct SeqList *p, int len) {
    int *q = p->data; // 保存原数组的数据
    p->data = (int *) malloc((p->MaxSize + len) * sizeof(int)); // 扩容 + 并改变原始的data的引用位置为新的扩容后的数组的第一个值的地址
    for (int i = 0; i < p->length; i++) {
        // 把原来的值，拷贝到现在的扩容后的数组里面
        p->data[i] = q[i];
    }
    // 设置最大长度的值
    p->MaxSize = p->MaxSize + len;
    free(q); // 释放到此前的引用数组副本
}
//销毁
void DestroyList(struct SeqList *p) {
    p->length = 0;
    free(p->data);
    p->MaxSize = InitSize;
}
//    删除操作
int ListDelete(struct SeqList *p, int i, int e) {

    int *q = p->data;


    return 0;
}
int main() {
    struct SeqList list;
    InitList(&list);
    // 扩容
    IncreaseSize(&list, 10);
    printf("list MaxSize = %d", list.MaxSize);

    // 销毁
    DestroyList(&list);
    for(int i = 0; i < list.length; i++){
        printf("list.data[%d] = %d", list.data[i]);
    }

//    删除操作

    return 0;
}

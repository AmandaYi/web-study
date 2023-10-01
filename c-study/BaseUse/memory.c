

#include <stdio.h>
#include <string.h>
#include <malloc.h>
int main()
{

  char name[100];

  char *description;

  strcpy(name, "hahhah~");
  printf("%d\n",sizeof(char));
  description = malloc(sizeof(char) * 1024 * 1024 * 1024 * 1024 * 1024 );

  if (description == NULL)
  {
    // fprintf(stderr, "ERROE,分配内存失败！"); //
    printf("分配内存失败！");
  }
  else
  {

    strcpy(description, "ABCDABCDABCDABCD");

    // strcpy()
  }
  // printf("%s\n",name);
  printf("%s\n", description);
  free(description);

  // while (1)
  // {
    /* code */
  // }
  
  // calloc(); // 该函数
  // realloc(); // 重新分配内容，把内存扩展到新的大小
  
  // 一个字节多少个英语单词
// 3.14159
// 35
  510E1;
  210.1f;
  
  return 0;
}
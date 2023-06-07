#include <stdio.h>
#include <string.h>

struct Stu
{
  int sid;
  char name[200];
};
void f(int *p, int a);

void funLike(char *name)
{
  printf("%s", name);
}
int main()

{
  struct Stu st = {1, "小明"};

  struct Stu *pst;

  strcpy(pst->name, "小");
  printf("st:name%s", pst->name);
  strcpy((*pst).name, "大");
  printf("st:name%s", (*pst).name);
  pst->sid = 1;

  return 0;
}

void f(int *p, int a)
{
  *p = a;
}
#include <stdio.h>
#include <windows.h>

void loveYou(int n)
{
  int i = 0;
  int j = 0;
  int count = 0;
  while (i <= n)
  {
    i++;
    for (j = 0; j < n; j++)
    { 
      count++;
      printf("I love You %d \n", count);
      system("start notepad"); 
    }
  }
  printf("sum %d", n * n);
}

int main()
{
  loveYou(3);
  return 0;
}
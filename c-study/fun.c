#include <stdio.h>

void sayHi();
int fun1(int);
int max(int num1, int num2);
int max2(int num1, int num2, int num3);
int main()
{
  // sayHi("Maki", 10);
  // int result = fun1(2);
  // printf("%d",result);
  printf("%d", max2(10, 2, 3));
  return 0;
}

void sayHi(char name[], int age)
{
  printf("Hello %s~ %d", name, age);
}
int fun1(int num)
{
  if (num <= 0)
  {
    return 0;
  }
  return num * num * num;
}

int max(int num1, int num2)
{
  if (num1 >= num2)
  {
    return num1;
  }
  return num2;
}

int max2(int num1, int num2, int num3)
{
  if (num1 >= num2 && num1 >= num3)
  {
    return num1;
  }
  else if (num2 >= num1 && num2 > num3)
  {
    return num2;
  }
  else
  {
    return num3;
  }
}
int max3(int num, ...) {
  // va_list args;s
  // vfscanf;
  // int ret;
	// va_list args;
	// va_start(args, format);
	// ret = vsscanf(str, format, args);
	// va_end(args);
	// return ret;
}
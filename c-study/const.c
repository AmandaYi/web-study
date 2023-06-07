
#include <stdio.h>

#define LENGTH 10

int main () {
  printf("%d\n", LENGTH);
  const char width[500] = "123456";
  // width = "456789123";
  printf("%s\n", width);
  return 0;
}

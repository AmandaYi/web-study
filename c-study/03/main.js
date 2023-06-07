function loveYou(n) {
  let i = 0;
  let j = 0;
  let count = 0;
  while (i <= n) {
    i++;
    for (j = 0; j < n; j++) {
      count++;
      console.log("I love You %d", count);
    }
  }
  console.log("sum %d", n * n);
}

loveYou(300);
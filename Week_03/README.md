#### 1、递归模板

```java
recursion(level, param){
    //recursion terminator
    
    //process logic in current level
    
    //drill down
    
    //revert the current level status if need
}
```

#### 2、分治模板

```java
private static int divide_conquer(Problem problem, ) {
  //recursion terminator
  if (problem == NULL) {
    int res = process_last_result();
    return res;     
  }
  //prepare data
  subProblems = split_problem(problem)
  //conquer subproblems
  res0 = divide_conquer(subProblems[0])
  res1 = divide_conquer(subProblems[1])
  //process and generate the final result
  result = process_result(res0, res1);
  //revert the current level states
  return result;
}
```

#### 3、回溯

* 采用试错的思想，尝试分步的去解决一个问题，在分步解决问题的过程中，当尝试发现现有分步答案不能得到有效的正确解答时，它将取消上一步甚至上几步的计算，再通过其它可能分步解答寻找问题答案。
* 通常使用递归实现，可能出现两种结果：找到一个可能存在的正确答案/尝试了所有可能没有答案
* 最坏情况下，回溯法会导致一次复杂度为指数时间的计算


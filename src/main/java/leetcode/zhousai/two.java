package leetcode.zhousai;

import java.util.Arrays;

/**
 * @description:
 * @author:maidang
 * @date:2021/04/18
 **/
public class two {
  public int maxIceCream(int[] costs, int coins) {
    int count=0;
    Arrays.sort(costs);
    int i=0;
    while(i< costs.length&&coins>=costs[i]){
      coins-=costs[i];
      i++;
      count++;
    }
    return count;
  }
}

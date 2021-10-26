package leetcode;

/**
 * @description:
 * @author:maidang
 * @date:2021/02/04
 **/
public class leetcode634 {
  public double findMaxAverage(int[] nums, int k) {
    //滑动窗口的做法
    int left=0;
    double count=0;
    double avg=Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if(i-left<k){
        count+=nums[i];
      }else{
        avg=Math.max(avg,count/k);
        count+=nums[i];
        count-=nums[left++];
      }
    }
    avg=Math.max(avg,count/k);
    return avg;
  }

}

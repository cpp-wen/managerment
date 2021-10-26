package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @description: 周赛2
 * @author:maidang
 * @date:2020/12/27
 **/
public class leetcode2 {

  public static void main(String[] args) {
//    int [][]test= new int[][]{{1},{-1},{-1},{-1},{1},{-1},{-1},{1},{1},{1},{1},{1},{-1},{1},{1},{1},{1},{-1},{1},{-1},{1},{-1},{-1},{1},{-1},{1},{-1},{-1},{1},{-1},{-1},{1},{1},{1},{1},{-1},{1},{-1},{-1},{-1},{-1},{-1},{-1},{-1},{1},{1},{-1},{1},{-1},{-1},{-1},{-1},{-1},{-1},{1},{1},{-1},{-1},{1},{1},{1},{-1},{-1},{-1},{-1},{-1},{-1},{-1},{-1},{1},{1},{-1},{1},{-1},{1},{1},{1},{1},{-1},{1},{-1},{1},{1},{1},{-1},{1},{-1},{1},{-1},{1},{1},{-1},{-1},{1},{1},{-1},{1},{-1},{1},{-1}
//    };
//    findBall(test);
    HashMap<String,String> hashMap;

  }
  public boolean halvesAreAlike(String s) {
    int length=s.length();
    String con="aeiouAEIOU";
    int left=0;
    int right=0;
    for (int i = 0; i < length/2; i++) {
      if(con.contains(String.valueOf(s.charAt(i)))){
      left++;
      }
    }
    for (int i=length/2;i<length;i++){
      if(con.contains(String.valueOf(s.charAt(i)))){
        right++;
      }
    }
    return left==right;
  }
  public static int eatenApples(int[] apples, int[] days) {
    //eat apple
    int res=0;
    PriorityQueue<apple> priorityQueue=new PriorityQueue<>(new Comparator<apple>() {
      @Override
      public int compare(apple o1, apple o2) {
        //先吃快到保质期的
        return o1.endtime-o2.endtime;
      }
    });
    for (int i = 0; i < apples.length; i++) {
      if(apples[i]==0){

      }else{
        apple apple=new apple();
        apple.count=apples[i];
        apple.endtime=days[i]+i-1;
        priorityQueue.add(apple);
      }
      //如果不为空
      while(!priorityQueue.isEmpty()){
        apple peek = priorityQueue.peek();
        if(peek.endtime<i||peek.count<=0){
          priorityQueue.poll();
        }else{
          peek.count--;
          res++;
          break;
        }
      }
    }
    //这边解决最终没有过期的苹果
    int i=apples.length;
    while(!priorityQueue.isEmpty()){
      //将 苹果放入
      apple peek = priorityQueue.peek();
      if(peek.endtime<i||peek.count<=0){
        priorityQueue.poll();
      }else{
        peek.count--;
        res++;
        i++;
      }
    }
    return res;
  }
  private static class apple{
    int endtime;
    int count;
  }
  public static int[] findBall(int[][] grid) {
    //小球滚动位置距离
    int res[]=new int[grid[0].length];
    //每个球都遍历一次
    for (int i = 0; i < res.length; i++) {
      if((i==0&&grid[0][0]==-1)||(i==res.length-1&&grid[0][grid[0].length-1]==1)){
        res[i]=-1;
        continue;
      }
      //右边转
      int col=i;
      int row=0;
      while(true){
        //如果左右两边 相同
        if(grid[row][col]==1&&col+1<grid[0].length&&grid[row][col+1]==1){
              //右边走 、
            row+=1;
            col+=1;
            if(row>=grid.length){
              res[i]=col;
              break;
            }
        }
        else if(grid[row][col]==-1&&col-1>=0&&grid[row][col-1]==-1){
          //left zou
          row+=1;
          col-=1;
          if(row>=grid.length){
            res[i]=col;
            break;
          }
        }
        else{
          res[i]=-1;
          break;
        }
      }
    }
    return res;
  }
}

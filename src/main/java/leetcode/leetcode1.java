package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @description: 周赛1
 * @author:maidang
 * @date:2020/12/26
 **/
public class leetcode1 {


  public static void main(String[] args) {
    //System.out.println(countStudents(new int[]{0,0,0,1,0,1,1,1,1,0,1}, new int[]{0,0,0,1,0,0,0,0,0,1,0}));


  }
  public static int countStudents(int[] students, int[] sandwiches) {
    int s1=0;
    int s0=0;
    int sw0=0;
    int sw1=0;
    for (int i = 0; i < students.length; i++) {
      if(students[i]==0){
        s0++;
      }else{
        s1++;
      }
      if(sandwiches[i]==0){
        sw0++;
      }else{
        sw1++;
      }
    }
    for(int i=0;i<students.length;i++){
      if(sandwiches[i]==0){
        s0--;
      }else{
        s1--;
      }
      if(s0<0||s1<0){
        return s1+s0+1;
      }
    }
    return 0;
  }
  public double averageWaitingTime(int[][] customers) {
    Arrays.sort(customers, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[0]<o2[0]){
          return 1;
        }else{
          if(o1[1]<o2[1]){
            return 1;
          }
        }
        return 0;
      }
    });
    Double res=0.0;
    int pre=customers[0][0];
    for(int i=0;i<customers.length;i++){
      if(pre<=customers[i][0]){
        res+=customers[i][1];
        pre=customers[i][0]+customers[i][1];
      }else{
        res+=pre-customers[i][0]+customers[i][1];
        pre=pre+customers[i][1];
      }
    }
    return res/customers.length;
  }
  public  String maximumBinaryString(String binary) {
    StringBuilder res=new StringBuilder();
    int i=0;
    if(Objects.equals(binary,"0")){
      return "0";
    }
    while(i<binary.length()&&binary.charAt(i)!='0'){
      i++;
      res.append('1');
    }
    int zerocount=0;
    int onecount=0;
    for (int j = i; j <binary.length();j++) {
      if(binary.charAt(j)=='1'){
        onecount++;
      }else{
        zerocount++;
      }
    }
    for (int j = 0; j < zerocount-1; j++) {
      res.append('1');
    }
    if(zerocount!=0){
      res.append('0');
    }
    for (int j = 0; j < onecount; j++) {
      res.append('1');
    }
    return res.toString();
  }
}

package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * @description:周赛第三场
 * @author:maidang
 * @date:2021/01/03
 **/
public class leetcode3 {

  public static void main(String[] args) {
    //maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4);
    System.out.println(countPairs(
        new int[]{2, 14, 11, 5, 1744, 2352, 0, 1, 1300, 2796, 0, 4, 376, 1672, 73, 55, 2006, 42, 10,
                  6, 0, 2, 2, 0, 0, 1, 0, 1, 0, 2, 271, 241, 1, 63, 1117, 931, 3, 5, 378, 646, 2, 0,
                  2, 0, 15, 1}));
  }

  public static int maximumUnits(int[][] boxTypes, int truckSize) {
    int res = 0;
    Arrays.sort(boxTypes, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[1] - o1[1];
      }
    });
    int i = 0;
    //这边会有越界问题
    while (truckSize >= 0 && i < boxTypes.length) {
      res +=
          truckSize > boxTypes[i][0] ? boxTypes[i][0] * boxTypes[i][1] : truckSize * boxTypes[i][1];
      truckSize -= boxTypes[i][0];
      i++;
    }
    return res;
  }


  //  public static int countPairs(int[] deliciousness) {
//    long res=0;
//    for(int i=0;i<deliciousness.length;i++){
//      for (int j = i+1; j <deliciousness.length; j++) {
//        int num=deliciousness[i]+deliciousness[j];
//          if((num&(num-1))==0){
//            res++;
//          }
//      }
//    }
//    return (int)(res%(Math.pow(10,9)+7));
//  }
  public static int countPairs(int[] deliciousness) {
    long res = 0;
    //for for
//    HashMap<Integer, Integer> hashMap = new HashMap<>();
//    for (int i = 0; i <deliciousness.length; i++) {
//        hashMap.put(deliciousness[i],hashMap.getOrDefault(deliciousness[i],0)+1);
//    }
    HashSet<Long> hashSet=new HashSet<>();
 //   遍历hash
    for (int i = 0; i < deliciousness.length; i++) {
      for (int j = i + 1; j < deliciousness.length; j++) {
        long num = deliciousness[i] + deliciousness[j];
        if(hashSet.contains(num)){
          res++;
        }
        else if (num!=0&&(num & (num - 1)) == 0) {
          hashSet.add(num);
          res++;
        }
      }
    }
//    for (Integer j:hashMap.keySet()) {
//      if(hashMap.get(j)==0){
//        continue;
//      }
//      for (Integer key:hashMap.keySet()) {
//        if(hashMap.get(key)==0){
//          continue;
//        }
//        int num=j+key;
//        if(num!=0&&((num&(num-1))==0)){
//          res+=hashMap.get(key);
//          if(key.equals(j)){
//            res--;
//            System.out.println(res);
//          }
//        }
//      }
//      hashMap.put(j,hashMap.get(j)-1);
//    }

//    for (Iterator it = hashMap.entrySet().iterator(); it.hasNext();){
//      Map.Entry<Integer, Integer> item = (Map.Entry<Integer, Integer>) it.next();
//      Integer key = item.getKey();
//
//      for (Iterator it1 = hashMap.entrySet().iterator(); it.hasNext();) {
//        Map.Entry<Integer, Integer> item1 = (Map.Entry<Integer, Integer>) it.next();
//        Integer key1 = item.getKey();
//        int num=key1+key;
//        if(num!=0&&((num&(num-1))==0)){
//          res+=item.getValue();
//          System.out.println(key+" "+key1+" "+num);
//          if(key.equals(key1)){
//            res--;
//          }
//        }
//      }
//      hashMap.put(key,hashMap.get(key)-1);
//      if(hashMap.get(key)==0){
//        it.remove();
//      }
//    }


    return (int)(res % (long) (Math.pow(10, 9) + 7));
    //return res;
  }
}

package leetcode.zhousai;

/**
 * @description:
 * @author:maidang
 * @date:2021/04/18
 **/
public class three {

  public static void main(String[] args) {
    three mai=new three();
    System.out.println(
        mai.getXORSum(new int[]{1033, 4179, 1931, 8117, 7364, 7737, 6219, 3439, 1537, 7993},
                      new int[]{6386}));
  }
  public int getXORSum(int[] arr1, int[] arr2) {
    //先交叉and  后异或
    //修改为先 短数组先异或然后再and
    int arr1length=arr1.length;
    int arr2length=arr2.length;
    int num1;
    int num2;
    num1=hebing(arr1);
    num2=hebing(arr2);
    return num1&num2;
  }
  public int hebing(int []array){
    int number=array[0];
    for (int i = 1; i <array.length; i++) {
      number^=array[i];
    }
    return number;
  }
}

package leetcode.zhousai;

import java.util.HashSet;

/**
 * @description:
 * @author:maidang
 * @date:2021/04/18
 **/
public class one {

  public boolean checkIfPangram(String sentence) {
    if (sentence.length() < 26) {
      return false;
    }
    HashSet<Character> hashSet = new HashSet<>();
    for (int i = 0; i < sentence.length(); i++) {
      hashSet.add(sentence.charAt(i));
      if(hashSet.size()==26){
        return true;
      }
    }
    return false;
  }
}

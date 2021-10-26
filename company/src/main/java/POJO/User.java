package POJO;

/**
 * @description:
 * @author:maidang
 * @date:2021/09/27
 **/
public class User {
  public String name;
  public String word;

  public User(String name, String word) {
	this.name = name;
	this.word = word;
  }

  @Override
  public String toString() {
	return "User{" +
		   "name='" + name + '\'' +
		   ", word='" + word + '\'' +
		   '}';
  }

  public User() {
  }
}

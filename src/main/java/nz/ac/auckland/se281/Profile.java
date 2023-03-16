package nz.ac.auckland.se281;

public class Profile {

  String name;
  int age;

  public Profile(String name, String age) {
    this.name = name;
    this.age = Integer.valueOf(age);
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}

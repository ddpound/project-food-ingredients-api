package com.foodi.projectfoodingredientsback.testcon.testmodel;

public class Human{
    // 변수 이름자체는 크게 따지지않는것 같다
    private String Name;
    private  String age;

    public Human() {
    }

    public Human(String name, String age) {
        this.Name = name;
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

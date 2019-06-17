package com.yq.reflext;

public class Person {

    private String name;

    private Integer age;

    private String xx;

    public String haha;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Integer age, String xx, String haha) {
        this.name = name;
        this.age = age;
        this.xx = xx;
        this.haha = haha;
    }

    private void haha() {
        System.out.println("hahahaha......");
    }

    public void eat(String food) {
        System.out.println("eat......" + food);
    }

    public void say(String hua) {
        System.out.println("say......" + hua);
    }
}

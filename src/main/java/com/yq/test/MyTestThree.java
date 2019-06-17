package com.yq.test;

import java.lang.reflect.Field;

public class MyTestThree {

    public static void main(String[] args) throws Exception{

        Class<?> personClazz = Class.forName("com.yq.test.Person");
        Person p = (Person) personClazz.newInstance();

        Field nameFile = personClazz.getDeclaredField("name");

        nameFile.setAccessible(true);

        nameFile.set(p, "cyq");

        Field ageField = personClazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(p, 18);

        System.out.println(p);

    }

}

package com.example.qfang_web.reflex;

import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiexiangyi
 * @date 2018/7/20
 */


public class Test1 {
    private List<Field> fieldList;
    @Test
    public void  test1() throws ClassNotFoundException {
        ArrayList<Student> students=new ArrayList<>();
        students.add(new Student("zhangshan",1));
        students.add(new Student("lisi",2));
        students.add(new Student("wangwu",3));
        students.add(new Student("dengliu",4));
        students.add(new Student("limimg",5));
        Class<?> aClass = Class.forName("com.example.qfang_web.reflex.Student");
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        this.Test1(students,aClass);

    }

    public void Test1(List<?> list,Class<?> cls){
        ReflectionUtils.doWithFields(cls, field -> {
            ReflectionUtils.makeAccessible(field);
            fieldList.add(field);
        }, field -> {
            final int mod = field.getModifiers();
            return!(Modifier.isStatic(mod)&&Modifier.isFinal(mod));
        });
        fieldList.forEach(System.out::println);
    }

}

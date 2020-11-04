package org.sxyxhj.restapidemo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: spring-boot-demo
 * @description: Person
 * @author: @sxyxhj
 * @create: 2020-11-04 18:12
 **/
@Data
public class Person implements Serializable {
    public String name;
    public int age;
}

    

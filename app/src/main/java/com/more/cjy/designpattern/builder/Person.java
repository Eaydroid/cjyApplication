package com.more.cjy.designpattern.builder;

/**
 * {此处写描述信息}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/8 15:18
 * 邮箱：303592161@qq.com
 */
public class Person {
    private String name;
    private int age;
    private int sex;
    private String job;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
        this.job = builder.job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", job='" + job + '\'' +
                '}';
    }

    static class Builder {
        private String name;
        private int age;
        private int sex;
        private String job;

        public Builder setName(String name) {
            this.name = name;

            return this;
        }
        public Builder setAge(int age) {
            this.age = age;

            return this;
        }
        public Builder setSex(int sex) {
            this.sex = sex;

            return this;
        }
        public Builder setJob(String job) {
            this.job = job;

            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}

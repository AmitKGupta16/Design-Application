package com.develop.designpattern.builder;

import lombok.Builder;

@Builder
public class Student {
    private String name;
    private int age;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private String course;
    private String major;
    private Student(StudentBuilder studentBuilder){
        this.name = studentBuilder.name;
        this.age = studentBuilder.age;
        this.gender = studentBuilder.gender;
        this.address = studentBuilder.address;
        this.phone = studentBuilder.phone;
        this.email = studentBuilder.email;
        this.course = studentBuilder.course;
        this.major = studentBuilder.major;
    }

    public static class StudentBuilder {
        private String name;
        private int age;
        private String gender;
        private String address;
        private String phone;
        private String email;
        private String course;
        private String major;
        public StudentBuilder(){
        }

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }
        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }
        public StudentBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }
        public StudentBuilder address(String address) {
            this.address = address;
            return this;
        }
        public StudentBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public StudentBuilder email(String email) {
            this.email = email;
            return this;
        }
        public StudentBuilder course(String course) {
            this.course = course;
            return this;
        }
        public StudentBuilder major(String major) {
            this.major = major;
            return this;
        }
        public Student build() {
            return new Student(this);
        }
    }
}

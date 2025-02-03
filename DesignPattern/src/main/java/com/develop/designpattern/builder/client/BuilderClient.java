package com.develop.designpattern.builder.client;

import com.develop.designpattern.builder.Student;

public class BuilderClient {
    public static void main(String[] args) {
        Student student = new Student.StudentBuilder()
                .age(10)
                .address("Bangalore").build();

    }
}

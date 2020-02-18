package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {
    private List<Student> students= new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double value) {
        for (Student student: students) {
            if (student.getAverageGrade() == value) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Comparator<Student> comparator = Comparator.comparingDouble(Student::getAverageGrade);
        students.sort(comparator);
        return students.get(students.size()-1);

    }

    public Student getStudentWithMinAverageGrade() {
        Comparator<Student> comparator = new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getAverageGrade(),o2.getAverageGrade());
            }
        };
        students.sort(comparator);
        return students.get(0);
    }

    public void expel(Student student){
        students.remove(student);
    }

}
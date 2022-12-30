package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    StudentRepository sturepo;

    public void addStudent(Student student){
        sturepo.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        sturepo.addTeacher(teacher);
    }

    public void addPair(String student,String teacher){
        sturepo.addPair(student,teacher);
    }

    public Student getStudent(String name){
        return sturepo.getStudent(name);
    }

    public Teacher getTeacher(String name){
        return sturepo.getTeacher(name);
    }

    public List<String> getListOfStudents(String teacher){
        return sturepo.getListOfStudents(teacher);
    }

    public List<String> getAllStudents(){
        return sturepo.getAllStudents();
    }

    public void deleteTeacherStudents(String teacher){
        sturepo.deleteTeacherStudents(teacher);
    }

    public void deleteAllTeachersStudents() {
        sturepo.deleteAllTeachersStudents();
    }
}

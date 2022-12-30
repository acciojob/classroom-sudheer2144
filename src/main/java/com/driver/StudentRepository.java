package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    HashMap<String,Student> students;
    HashMap<String,Teacher> teachers;
    HashMap<String,List<String>> pair;

    public StudentRepository() {
        this.students=new HashMap<>();
        this.teachers=new HashMap<>();
        this.pair=new HashMap<>();
    }

    public void addStudent(Student student){
        String studentName=student.getName();
        students.put(studentName,student);
    }

    public void addTeacher(Teacher teacher){
        String teacherName=teacher.getName();
        teachers.put(teacherName,teacher);
    }

    public void addPair(String student,String teacher){
        List<String> studentList=new ArrayList<>();;
        if(pair.containsKey(teacher)) {
            studentList=pair.get(teacher);
        }
        studentList.add(student);
        pair.put(teacher,studentList);
    }

    public Student getStudent(String name){
        return students.get(name);
    }

    public Teacher getTeacher(String name){
        return teachers.get(name);
    }

    public List<String> getListOfStudents(String teacher){
        return pair.get(teacher);
    }

    public List<String> getAllStudents(){
        return new ArrayList<>(students.keySet());
    }

    public void deleteTeacherStudents(String teacher){
        List<String> studentNames=pair.get(teacher);
        for(String studentName:studentNames){
            if(students.containsKey(studentName)){
                students.remove(studentName);
            }
        }
        if(teachers.containsKey(teacher)) {
            teachers.remove(teacher);
        }
        pair.remove(teacher);
    }

    public void deleteAllTeachersStudents() {
        for (String teacher : pair.keySet()) {
            List<String> studentNames = pair.get(teacher);
            for (String studentName : studentNames) {
                if (students.containsKey(studentName)) {
                    students.remove(studentName);
                }
            }
            pair = new HashMap<>();
            teachers = new HashMap<>();
        }
    }
}

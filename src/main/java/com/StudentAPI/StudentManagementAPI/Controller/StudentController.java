package com.StudentAPI.StudentManagementAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentAPI.StudentManagementAPI.Entity.Student;
import com.StudentAPI.StudentManagementAPI.Service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/management")
public class StudentController {

	

    @Autowired
       private StudentService studentService;
      
    
    @PostMapping("/newstudent")
    public Student addStudentDetails(@RequestBody @Valid Student student) {
    	return studentService.saveStudent(student);
    }
    @PostMapping("/saveall")
    public List<Student> saveAll(@RequestBody@Valid List<Student> students){
    	return studentService.saveStudents(students);
    }
    
    @GetMapping("/students")
    public List<Student> getAllStudents(){
    	return studentService.listAll();
    }
    @GetMapping("/getstudent/{id}")
    public Student getStudentById(@PathVariable Long id){
    	return studentService.get(id) ;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
    	studentService.delete(id);
    }
    
    
    
    @PutMapping("/update")
    public Student updateStudent(@RequestBody @Valid Student student) {
    	return studentService.updateStudent(student);
    }
    
}

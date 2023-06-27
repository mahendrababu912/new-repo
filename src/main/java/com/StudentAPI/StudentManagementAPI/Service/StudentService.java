package com.StudentAPI.StudentManagementAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentAPI.StudentManagementAPI.Entity.Student;
import com.StudentAPI.StudentManagementAPI.Repository.StudentRepository;

@Service
public class StudentService  {
	
	@Autowired
	private StudentRepository studentRepository;
	
	//to save list of students
	public List<Student> saveStudents(List<Student> student){
		
		return studentRepository.saveAll(student);
		}
	//to save the students
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	//to get the student by id
	
	public Student get(Long id) {
		return studentRepository.findById(id).orElse(null);
		
	}
	//to get all students
        public List<Student> listAll(){
		
		return studentRepository.findAll();
		}
	//to delete student
	
	public String delete(Long id) {
		studentRepository.deleteById(id);
		return "removed"+id;
	}
	
	//Update studentDetails
	
	public Student updateStudent(Student students) {
		Student existingStudent=studentRepository.findById(students.getId()).orElse(null);
		existingStudent.setStudentname(students.getStudentname());
		existingStudent.setCourse(students.getCourse());
		existingStudent.setFee(students.getFee());
		return studentRepository.save(existingStudent);
		
	}

}

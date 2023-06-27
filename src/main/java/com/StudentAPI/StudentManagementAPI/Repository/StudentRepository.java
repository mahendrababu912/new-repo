package com.StudentAPI.StudentManagementAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentAPI.StudentManagementAPI.Entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

}

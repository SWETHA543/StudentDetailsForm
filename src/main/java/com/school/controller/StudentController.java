package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.Student;
import com.school.service.StudentService;
import com.school.utility.ResponseStructure;

@RestController
public class StudentController 
{
	
	@Autowired
	public StudentService ser;
	
	@PostMapping("/students")
	public ResponseEntity<ResponseStructure<String>> insertdata(@RequestBody Student stu)
	{
		return ser.insertService(stu);
			
	}
	@GetMapping("students/{stuid}")
	public ResponseEntity<ResponseStructure<Student>> findById(@PathVariable int stuid)
	{
		return ser.findByIdService(stuid);
	}
	@GetMapping("student/{stuname}")
	public ResponseEntity<ResponseStructure<Student>> findByName(@PathVariable String stuname)
	{
		return ser.findByNameService(stuname);
	}
	@GetMapping("studentss/{stunumber}")
	public ResponseEntity<ResponseStructure<Student>> findByNumber(@PathVariable Long stunumber)
	{
		return ser.findByNumberService(stunumber);
	}
	@PutMapping("studentss/{stuid}")
	public ResponseEntity<ResponseStructure<String>> UpdateController(@RequestBody Student stu,@PathVariable int stuid)
	{
		return ser.updateService(stu,stuid);
	}
	@DeleteMapping("studentsss/{stuid}")
	
	public ResponseEntity<ResponseStructure<Student>> deleteController(@PathVariable int stuid)
	{
		return ser.deleteService(stuid);
	}

}

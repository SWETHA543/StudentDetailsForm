package com.school.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.entity.Student;
import com.school.exceptionhandling.StudentNotFoundByNameException;
import com.school.exceptionhandling.StudentNotFoundException;
import com.school.repository.StudentRepository;
import com.school.utility.ResponseStructure;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository repo;

	public ResponseEntity<ResponseStructure<String>> insertService(Student stu) {
		
		repo.save(stu);
		
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("data added successfully");
		rs.setData("data added");
		return new  ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.FOUND);
		
		
		
	}

	public ResponseEntity<ResponseStructure<Student>> findByIdService(int stuid) {
		            Optional<Student> studentdeteils = repo.findById(stuid);
		            
		            
		            
		if(studentdeteils.isPresent())
		{
			Student stu1 = studentdeteils.get();
			ResponseStructure<Student> rs=new ResponseStructure<Student>();
			rs.setStatusCode(HttpStatus.FOUND.value());
			rs.setMessage("data fetched successfully");
			rs.setData(stu1);
			return new ResponseEntity<ResponseStructure<Student>>(rs, HttpStatus.FOUND);
			
		}
		else throw new  StudentNotFoundException("student detils not found by this Id");
		
	
	}

	public ResponseEntity<ResponseStructure<Student>> findByNameService(String stuname) {
		
		               Optional<Student> id2 = repo.findByName(stuname);
		               
		               if(id2.isPresent()) {
		               Student stu2 = id2.get();
		               ResponseStructure<Student> rs=new ResponseStructure<Student>();
		   			rs.setStatusCode(HttpStatus.FOUND.value());
		   			rs.setMessage("data fetched successfully");
		   			rs.setData( stu2);
		   			
		   			return new ResponseEntity<ResponseStructure<Student>>(rs, HttpStatus.FOUND);
	
	}
		               else throw new   StudentNotFoundByNameException("student detils not found by this Name");}

	public ResponseEntity<ResponseStructure<Student>> findByNumberService(Long stunumber) {
		                  Optional<Student> id3 = repo.findByNumber(stunumber);
		                  
		                  if(id3.isPresent())
		                  {
		                	  Student stu3 = id3.get();
		                	  ResponseStructure<Student> rs=new ResponseStructure<Student>();
		  		   			rs.setStatusCode(HttpStatus.FOUND.value());
		  		   			rs.setMessage("data fetched successfully");
		  		   			rs.setData( stu3);
		  		   			
		  		   			return new ResponseEntity<ResponseStructure<Student>>(rs, HttpStatus.FOUND);
		  	
		                  }
		                  else throw new StudentNotFoundException("details not found");
		                  				
	}

	public ResponseEntity<ResponseStructure<String>> updateService(Student stu, int stuid) {

		Optional<Student> id4 = repo.findById(stuid);
		
		if(id4.isPresent())
		{
			Student student = id4.get();
			student.setName(stu.getName());
			student.setEmail(stu.getEmail());
			student.setBloodgroup(stu.getBloodgroup());
			student.setCollege(stu.getCollege());
			student.setCourse(stu.getCourse());
			student.setDob(stu.getDob());
			student.setGender(stu.getGender());
			student.setNumber(stu.getNumber());
			stu.setPassedoutyear(stu.getPassedoutyear());
			
			repo.save(student);
			
			ResponseStructure<String> rs=new ResponseStructure<String>();
	   			rs.setStatusCode(HttpStatus.FOUND.value());
	   			rs.setMessage("data updated successfully");
	   			rs.setData( "updated successfully");
	   			
	   			return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.FOUND);

		}
		else throw new StudentNotFoundException("student not found by this id");
		
		
	
	}

	public ResponseEntity<ResponseStructure<Student>> deleteService(int stuid) {
		           Optional<Student> id5 = repo.findById(stuid);
		           
		           if(id5.isPresent())
		           {
		        	   Student student1 = id5.get();
		        	   repo.deleteById(stuid);
		        	   ResponseStructure<Student> rs=new ResponseStructure<Student>();
			   			rs.setStatusCode(HttpStatus.FOUND.value());
			   			rs.setMessage("data deleted successfully");
			   			rs.setData(student1 );
			   			
			   			return new ResponseEntity<ResponseStructure<Student>>(rs, HttpStatus.FOUND);

		        	   
		           }
		           else throw new StudentNotFoundException("student not found by this id");
		        	   
	}

}

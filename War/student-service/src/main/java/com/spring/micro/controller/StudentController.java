package com.spring.micro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.micro.entity.Student;
import com.spring.micro.entity.StudentResponse;
import com.spring.micro.model.StudentDetails;
import com.spring.micro.service.StudentService;

@RestController
@RequestMapping("/api/khasim")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/save")
	public Student createStudent(@RequestBody StudentDetails studentDetails)
	{
		return studentService.createStudent(studentDetails);
	}
	
	@GetMapping("/getall")
	public List<Student> getStudents()
	{
		return studentService.getStudents();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Student> getStudent(@PathVariable long id)
	{
		return studentService.getStudentById(id);
	}
	
	
//	1.Approach Communicating with RestTemplate
//	@GetMapping("/getbyid/{id}")
//	public StudentResponse getByid(@PathVariable long id)
//	{
//			return studentService.getstudentwithAddress(id);
//	}
	
	
//	2.Approach Communicating with WebClient
//	@GetMapping("/getById/{id}")
//	public StudentResponse getByid(@PathVariable long id)
//	{
//			return studentService.getstudentwithAddress(id);
//	}
	
	
//	3.Approach Communicating with Feign-Client
	
	@GetMapping("/getByid/{id}")
    public StudentResponse getByid(@PathVariable long id) {
        return studentService.getstudentwithAddress(id);
    }
}
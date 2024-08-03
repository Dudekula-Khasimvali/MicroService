package com.spring.micro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import com.spring.micro.AddressFeignClient;
//import com.spring.micro.entity.AddressResponse;
import com.spring.micro.entity.Student;
import com.spring.micro.entity.StudentResponse;
import com.spring.micro.model.StudentDetails;
import com.spring.micro.repository.StudentRepository;


@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
//	@Autowired
//	RestTemplate restTemplate;
	
//	@Autowired
//	WebClient webClient;
	
//	@Autowired
//	AddressFeignClient addressFeignClient;
	
	@Autowired
	CommonService commonService;
	
//	@Value("${address.url}")
//	String baseUrl;
	
	
	
	public Student createStudent(StudentDetails studentDetails) {
		
		Student student = new Student();
		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		student.setEmail(studentDetails.getEmail());
		
		return studentRepository.save(student);
	}

	public List<Student> getStudents() {
		
		return studentRepository.findAll();
	}

	public Optional<Student> getStudentById(long id) {
		
		return studentRepository.findById(id);
	}
	
//	1.Approach Communicating with RestTemplate
//	public StudentResponse getstudentwithAddress(long id)
//	{
//		//get the student with id
//	Student student = 	studentRepository.findById(id).get();
//			
//			AddressResponse addressResponse = 	restTemplate.getForObject(baseUrl+id, AddressResponse.class);
//			StudentResponse studentResponse = new StudentResponse();
//			studentResponse.setId(student.getId());
//			studentResponse.setFirstName(student.getFirstName());
//			studentResponse.setLastName(student.getLastName());
//			studentResponse.setEmail(student.getEmail());
//			studentResponse.setAddressResponse(addressResponse);			
//			return studentResponse;
//	}
	
	
//	2.Approach Communicating with WebClient
//	public StudentResponse getstudentwithAddress(long id)
//	{
//		//get the student with id
//	Student student = 	studentRepository.findById(id).get();
//			
//	 AddressResponse addressResponse = webClient.get()
//	            .uri(baseUrl+ id)
//	            .retrieve()
//	            .bodyToMono(AddressResponse.class)
//	 			.block();
//	 StudentResponse studentResponse = new StudentResponse();
//			studentResponse.setId(student.getId());
//			studentResponse.setFirstName(student.getFirstName());
//			studentResponse.setLastName(student.getLastName());
//			studentResponse.setEmail(student.getEmail());
//			studentResponse.setAddressResponse(addressResponse);			
//			return studentResponse;
//	}
	
	
//	3.Approach Communicating with Feign-Client

	public StudentResponse getstudentwithAddress(long id) {

		//get the student with id
	Student student = 	studentRepository.findById(id).get();
	 StudentResponse studentResponse = new StudentResponse();
			studentResponse.setId(student.getId());
			studentResponse.setFirstName(student.getFirstName());
			studentResponse.setLastName(student.getLastName());
			studentResponse.setEmail(student.getEmail());
			studentResponse.setAddressResponse(commonService.getAddressById(id));			
			return studentResponse;
	}
	

} 

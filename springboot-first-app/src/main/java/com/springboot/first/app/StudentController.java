package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	// http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		return new Student("Adham", "Ahmed");
	}

	// http://localhost:8080/students
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Kareem", "El Kaderi"));
		students.add(new Student("Omar", "Ramadan"));
		students.add(new Student("Aly", "Raslan"));
		students.add(new Student("Youssef", "Rashad"));
		students.add(new Student("Nour", "El Bishlawy"));

		return students;
	}

	// http://localhost:8080/student/{firstName}/{lastName}
	@GetMapping("/student/{firstName}/{lastName}")
	public Student studentPahtVariable(@PathVariable("firstName") String fN, @PathVariable("lastName") String lN) {
		return new Student(fN, lN);
	}

	@GetMapping("/student/query")
	public Student studetnQueryParam(@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName) {
		return new Student(firstName, lastName);
	}
}

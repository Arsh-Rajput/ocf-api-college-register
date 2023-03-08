package ocf.api.college.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ocf.api.college.register.entity.Student;
import ocf.api.college.register.services.StudentService;

@RestController
@RequestMapping("v1")
public class CollegeRegisterController {

	@Autowired
	private StudentService studentService;

	@PostMapping(value = "welcome")
	public ResponseEntity<String> greatUser(@RequestBody String name) {
		String message = "Hello " + name;
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@PostMapping(value = "registration")
	public ResponseEntity<Student> registration(@RequestBody Student student) {

		student = studentService.save(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);

	}

	@GetMapping(value = "students")
	public ResponseEntity<List<Student>> students() {

		return new ResponseEntity<List<Student>>(studentService.findAll(), HttpStatus.OK);

	}

}

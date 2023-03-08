package ocf.api.college.register.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ocf.api.college.register.entity.Student;
import ocf.api.college.register.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

}

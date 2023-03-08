package ocf.api.college.register.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ocf.api.college.register.entity.Student;

@Component
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

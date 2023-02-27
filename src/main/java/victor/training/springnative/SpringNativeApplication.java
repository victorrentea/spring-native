package victor.training.springnative;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class SpringNativeApplication {
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringNativeApplication.class, args);
	}

	@Autowired
	private PersonRepo personRepo;

	@GetMapping("create")
	public void create() {
		personRepo.save(new Person("Nume"));
	}

	@GetMapping("list")
	public List<Person> aa() {
		return personRepo.findAll();
	}
}

@Getter
@Setter
@NoArgsConstructor
@Entity
class Person {
	@Id
	@GeneratedValue
	private Long id;
	private String name;

	public Person(String name) {
		this.name = name;
	}

}

interface PersonRepo extends JpaRepository<Person, Long> {
}

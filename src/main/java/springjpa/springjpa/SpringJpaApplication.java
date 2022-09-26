package springjpa.springjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springjpa.springjpa.entity.ChuyenBay;
import springjpa.springjpa.repository.ChuyenBayRepository;

@SpringBootApplication
public class SpringJpaApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

}

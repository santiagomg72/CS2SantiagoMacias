package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"app.adapter.out.persistance.entity"})
public class CastilloInfinitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CastilloInfinitoApplication.class, args);
	}

}

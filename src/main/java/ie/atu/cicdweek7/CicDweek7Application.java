package ie.atu.cicdweek7;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CicDweek7Application {

    public static void main(String[] args) {
        SpringApplication.run(CicDweek7Application.class, args);
    }

    @Bean
    public CommandLineRunner loadData(PersonRepository repo) {
        return args -> {
            repo.save(Person.builder()
                    .name("Alice Johnson")
                    .email("alice.johnson@example.com")
                    .employeeId("E001")
                    .position("Manager")
                    .department("HR")
                    .build());

            repo.save(Person.builder()
                    .name("Bob Smith")
                    .email("bob.smith@example.com")
                    .employeeId("E002")
                    .position("Developer")
                    .department("IT")
                    .build());

            repo.save(Person.builder()
                    .name("Charlie Brown")
                    .email("charlie.brown@example.com")
                    .employeeId("E003")
                    .position("Analyst")
                    .department("Finance")
                    .build());

            System.out.println("Sample data loaded into H2 database!");
        };
    }
}


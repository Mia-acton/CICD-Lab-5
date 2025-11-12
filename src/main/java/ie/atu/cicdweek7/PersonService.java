package ie.atu.cicdweek7;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public Person create(Person p) {
        return repo.save(p);
    }

    public List<Person> findAll() {
        return repo.findAll();
    }

    public Person findByEmployeeId(String id) {
        return repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
    }

    public Person update(String id, Person updatedPerson) {
        return repo.findByEmployeeId(id)
                .map(existing -> {
                    existing.setName(updatedPerson.getName());
                    existing.setEmail(updatedPerson.getEmail());
                    existing.setEmployeeId(updatedPerson.getEmployeeId());
                    existing.setPosition(updatedPerson.getPosition());
                    existing.setDepartment(updatedPerson.getDepartment());
                    return repo.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Person not found with ID " + id));
    }

    public void delete(String id) {
        repo.deleteByEmployeeId(id);
    }
}

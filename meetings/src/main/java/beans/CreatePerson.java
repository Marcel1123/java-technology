package beans;

import entities.Person;
import lombok.Getter;
import lombok.Setter;
import repository.PersonRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.UUID;

@Named
@RequestScoped
@Getter
@Setter
public class CreatePerson implements Serializable {
    private String name;
    @Inject
    private PersonRepository personRepository;

    public void savePerson(){
        if(!name.isEmpty()){
            Person person = new Person();
            person.setName(name);
            personRepository.add(person);
        }
    }
}

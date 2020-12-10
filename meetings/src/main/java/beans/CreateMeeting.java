package beans;

import entities.Meeting;
import entities.Person;
import lombok.Getter;
import lombok.Setter;
import repository.PersonRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
@Getter
@Setter
public class CreateMeeting {

    private PersonRepository personRepository = new PersonRepository();
    private Meeting meeting = new Meeting();

    private List<Person> persons = personRepository.getAll();
    private List<Person> selectedPersons;

    public void saveMeeting(){
        System.out.println(persons);
    }
}

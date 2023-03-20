package net.kumasi.ushop.domain.shopper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService  {

    @Autowired
    public PersonRepository repository;

    public List<Person> getPeople() {
        List<Person> modelList = new ArrayList<>();
        List<PersonEntity>  entities = repository.findAll();
        try {
            PersonMapper.mapToModel(modelList, entities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelList;
    }
    public int createPerson(Person person) {
        Optional<Person> modelOptional = Optional.ofNullable(this.readByEmailAddress(person.getEmail()));
        if(modelOptional.isPresent()) {
            throw new IllegalStateException("Email address already on file");
        }
        return savePerson(person);
    }
    public Person readPersonById(Integer id) {
        Person person = new Person();
        PersonEntity instance = null;
        Optional<PersonEntity> entity = repository.findById( id);

        if(entity.isPresent()) {
            instance = entity.get();
            mapModel(person, instance);
        }
        return person;
    }

    public Person readByEmailAddress(String email) {
        Person person = new Person();
        person.setEmail(email);
        PersonEntity instance = null;
        Optional<PersonEntity> entity = repository.findByEmail(person);

        if(entity.isPresent()) {
            instance = entity.get();
            mapModel(person, instance);
        }
        return person;
    }
    public int updatePerson(Person person) {
        return savePerson(person);
    }
    @Transactional
    public int deletePerson(Person person) {
        boolean exists = repository.existsById(person.getId());
        if(!exists) {
            throw new IllegalStateException("Person ID not on file so cannot delete it.");
        }
        repository.deleteById(person.getId());

        return 0;
    }
    @Transactional
    protected int savePerson(Person person) {
        PersonEntity instance =  new PersonEntity();
        int rc = mapDomain(instance, person);
        repository.save(instance);
        return rc;
    }

    private int mapModel(Person person, PersonEntity entity) {
        int rc = -1;
        try {
            PersonMapper.mapToModel(person, entity);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rc;
    }
    private int mapDomain(PersonEntity entity, Person person) {
        int rc = -1;
        try {
            PersonMapper.mapToDomain(entity, person);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rc;
    }
}

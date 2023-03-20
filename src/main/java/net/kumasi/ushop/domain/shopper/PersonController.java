package net.kumasi.ushop.domain.shopper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping(path = "/add")
    public void addPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }

    @GetMapping(path = "/people")
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @GetMapping(path = "{id}")
    public Person findById(@PathVariable("id") Integer id) {
        return personService.readPersonById(id);
    }

    @GetMapping(path = "{email}")
    public Person findByEmail(@PathVariable("email") String email) throws IllegalStateException{
        Optional<Person> modelOptional = Optional.ofNullable(personService.readByEmailAddress(email));
        if(modelOptional.isPresent()) {
            throw new IllegalStateException("Email address already on file");
        }
        return modelOptional.get();
    }

    @PutMapping(path = "/update")
    public void updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deletePerson(@PathVariable("id") Integer id) {
        Person person =  new Person();
        person.setId(id);
        personService.deletePerson(person);
    }
}


package ma.ulring.API.REST.Controller;

import ma.ulring.API.REST.Model.Personne;
import ma.ulring.API.REST.Service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personnes")
public class PersonneController {
    @Autowired
    private PersonneService personneService;

    @GetMapping()
    public List<Personne> getAllPersonnes() {
        return personneService.getAllPersonnes();
    }

    @GetMapping("{id}")
    public ResponseEntity<Personne> getPersonneById(@PathVariable("id") long personneId) {
        return new ResponseEntity<Personne>(personneService.getPersonneById(personneId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Personne> createPersonne(@RequestBody Personne personne) {
        return new ResponseEntity<Personne>(personneService.createPersonne(personne), HttpStatus.CREATED);

    }
    @PutMapping("{id}")
    public ResponseEntity<Personne> updatePersonne(@PathVariable("id") long personneId, @RequestBody Personne personne){
        return new ResponseEntity<Personne>(personneService.updatePersonne(personneId, personne), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePersonne(@PathVariable("id") long personneId){
        personneService.deletePersonne(personneId);
        return new ResponseEntity<String>("Personne deleted successfully!.", HttpStatus.OK);
    }
}

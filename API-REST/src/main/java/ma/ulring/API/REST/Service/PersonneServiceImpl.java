package ma.ulring.API.REST.Service;

import ma.ulring.API.REST.Exception.ResourceNotFoundException;
import ma.ulring.API.REST.Model.Personne;
import ma.ulring.API.REST.Repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneServiceImpl implements PersonneService{
    @Autowired
    PersonneRepository personneRepository;

    @Override
    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }

    @Override
    public Personne getPersonneById(long personneId) {
        return personneRepository.findById(personneId).orElseThrow(() ->
                new ResourceNotFoundException("Personne", "Id", personneId));
    }

    @Override
    public Personne createPersonne(Personne personne){
        return personneRepository.save(personne);
    }

    @Override
    public Personne updatePersonne(long personneId, Personne personneDetails){
        Personne personne = personneRepository.findById(personneId).orElseThrow(
                () -> new ResourceNotFoundException("Personne", "Id", personneId));
        personne.setCin(personneDetails.getCin());
        personne.setNom(personneDetails.getNom());
        personne.setPrenom(personneDetails.getPrenom());
        return personneRepository.save(personne);
    }

    @Override
    public void deletePersonne(long personneId) {
        personneRepository.deleteById(personneId);
    }

}

package ma.ulring.API.REST.Service;

import ma.ulring.API.REST.Model.Personne;

import java.util.List;

public interface PersonneService {
    public abstract List<Personne> getAllPersonnes();
    public abstract Personne getPersonneById(long personneId);
    public abstract Personne createPersonne(Personne personne);
    public abstract Personne updatePersonne(long personneId, Personne personneDetails);
    public abstract void deletePersonne(long personneId);
}

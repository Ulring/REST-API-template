package ma.ulring.API.REST.Repository;

import ma.ulring.API.REST.Model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,Long> {
}
package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Lokaal;

@Repository
public interface LokaalRepository extends JpaRepository<Lokaal, String>{
	
}

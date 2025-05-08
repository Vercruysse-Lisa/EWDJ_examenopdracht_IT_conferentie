package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Spreker;

@Repository
public interface SprekerRepository extends JpaRepository<Spreker, Integer>{

}

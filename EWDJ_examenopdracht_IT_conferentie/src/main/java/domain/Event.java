package domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String beschrijving; //optional
	LocalDateTime datumTijd;
	double prijs;
	
	@ManyToMany
	List<Spreker> sprekers;
	
	@ManyToOne
	Lokaal lokaal;
	
	@ManyToOne
	Beamer beamer;
}

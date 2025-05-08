package domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

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
	private int id;
	
	private String beschrijving; //optional
	
	private LocalDateTime datumTijd;
	
	private double prijs;
	
	@ManyToMany
	private Set<Spreker> sprekers;
	
	@ManyToOne
	private Lokaal lokaal;
	
	@ManyToOne
	private Beamer beamer;
}

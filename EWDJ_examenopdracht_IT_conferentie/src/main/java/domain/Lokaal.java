package domain;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Lokaal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Pattern(regexp = "^[A-Za-z]\\d{3}$")
	String lokaalNaam;
	
	@NotBlank
	@Size(min = 1, max = 50)
	int capaciteit;
	
	@OneToMany(mappedBy = "lokaal")
	List<Event> events;
	
}

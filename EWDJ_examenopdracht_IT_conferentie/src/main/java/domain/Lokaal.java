package domain;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@NotBlank
	@Pattern(regexp = "^[A-Za-z]\\d{3}$", message = "{lokaal.lokaalNaam.pattern}")
	private String lokaalNaam;
	
	@Min(1)
	@Max(50)
	@NotNull
	private int capaciteit;
	
	@OneToMany(mappedBy = "lokaal")
	private List<Event> events;
	
}

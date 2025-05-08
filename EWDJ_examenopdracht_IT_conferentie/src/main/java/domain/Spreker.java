package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Spreker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Pattern(regexp = "^[^\\s]+$", message = "{spreker.sprekerNaam.pattern}")
	private String voornaam;
	
	@NotBlank
	@Pattern(regexp = "^[^\\s]+$", message = "{spreker.sprekerNaam.pattern}")
	private String achternaam;
	
}

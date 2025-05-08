package validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import domain.Spreker;
import repository.SprekerRepository;

public class SprekerValidator implements Validator{
	
	@Autowired
	SprekerRepository sprekerRepository;
	
	@Override
	public boolean supports(Class<?> klass) {
		return Spreker.class.isAssignableFrom(klass);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Spreker spreker = (Spreker) target;
		
		if(spreker.getVoornaam() == null || spreker.getAchternaam() == null) {
			return;
		}
		
		List<Spreker> sprekers = sprekerRepository.findAll();
		for (Spreker s : sprekers) {
		    String fullNameDb = s.getVoornaam() + s.getAchternaam();
		    String fullNameNew = spreker.getVoornaam() + spreker.getAchternaam();
			if (fullNameDb.equalsIgnoreCase(fullNameNew)) {
				errors.rejectValue("achternaam", "spreker.name.combinationAlreadyExists");
			}
				
				
		}
	}
}

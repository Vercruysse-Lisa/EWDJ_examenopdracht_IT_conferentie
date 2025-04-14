package validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import domain.Lokaal;
import repository.LokaalRepository;

public class LokaalValidator implements Validator{
	
	@Autowired
	LokaalRepository lokaalRepository;
	
	@Override
	public boolean supports(Class<?> klass) {
		return Lokaal.class.isAssignableFrom(klass);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Lokaal lokaal = (Lokaal) target;
		
		if(lokaal.getLokaalNaam() == null) {
			return;
		}
		
		List<Lokaal> lokalen = lokaalRepository.findAll();
		for (Lokaal l : lokalen) {
			if (l.getLokaalNaam().equalsIgnoreCase(lokaal.getLokaalNaam())) {
				errors.rejectValue("lokaalNaam", "lokaal.lokaalNaam.naamBestaatAl");
			}
		}
	}
}
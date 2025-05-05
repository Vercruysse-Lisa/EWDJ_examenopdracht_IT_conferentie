package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Lokaal;
import repository.LokaalRepository;

@Service
public class LokaalService {
	
	@Autowired
	private LokaalRepository lokaalRepository;
	
	public Lokaal saveLokaal(Lokaal lokaal) {
		return lokaalRepository.save(lokaal);
	}
}

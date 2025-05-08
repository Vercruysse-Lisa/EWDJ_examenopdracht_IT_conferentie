package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Spreker;
import repository.SprekerRepository;

@Service
public class SprekerService {
	
	@Autowired
	private SprekerRepository sprekerRepository;
	
	public Spreker saveSpreker(Spreker spreker) {
		return sprekerRepository.save(spreker);
	}
}

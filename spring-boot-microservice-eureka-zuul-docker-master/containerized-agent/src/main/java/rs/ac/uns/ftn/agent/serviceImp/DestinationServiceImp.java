package rs.ac.uns.ftn.agent.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.agent.model.Destination;
import rs.ac.uns.ftn.agent.repository.DestinationRepository;
import rs.ac.uns.ftn.agent.service.DestinationService;



@Service
public class DestinationServiceImp implements DestinationService {

	@Autowired
	private DestinationRepository destinationRepository;

	@Override
	public List<Destination> findAll() {
		// TODO Auto-generated method stub
		return this.destinationRepository.findAll();
	}
	
	
	
	
}

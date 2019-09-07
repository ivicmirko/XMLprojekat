package rs.ac.uns.ftn.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.agent.model.Message;


public interface MessageRepository  extends JpaRepository<Message, Long>{

	List<Message> findByIdSender(Long id);
	List<Message> findByIdReceiver(Long id);
	
}

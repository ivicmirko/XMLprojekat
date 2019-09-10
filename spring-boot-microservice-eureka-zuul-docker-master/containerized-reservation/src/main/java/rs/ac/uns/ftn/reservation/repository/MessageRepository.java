package rs.ac.uns.ftn.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.reservation.model.Message;

public interface MessageRepository  extends JpaRepository<Message, Long>{

	List<Message> findByIdSender(Long idSender);
	List<Message> findByIdReceiver(Long idReceiver);
	
}

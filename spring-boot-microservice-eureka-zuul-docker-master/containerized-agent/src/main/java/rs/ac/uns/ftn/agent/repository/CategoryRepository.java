package rs.ac.uns.ftn.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.agent.model.Category;



@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	List<Category> findAll();
}

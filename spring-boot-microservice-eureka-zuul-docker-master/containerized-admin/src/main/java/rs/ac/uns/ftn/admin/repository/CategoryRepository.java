package rs.ac.uns.ftn.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.admin.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findOneByName(String name);
	Category saveAndFlush(Category category);
}

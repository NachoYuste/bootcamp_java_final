package data.jpa.test.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import data.jpa.test.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long>{
	
	List<Tutorial> findByPublished(boolean published);
	
	List <Tutorial> findByTitleContaining(String title);

}

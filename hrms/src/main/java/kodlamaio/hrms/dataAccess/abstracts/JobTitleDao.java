package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {
	
	//@Query("From JobTitle where jobPositions=:jobPositions")
	JobTitle getByJobPositions(String jobPositions);
	
	
}

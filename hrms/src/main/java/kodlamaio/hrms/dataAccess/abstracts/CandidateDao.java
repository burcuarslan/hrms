package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

	Candidate getByEmail(String email);
	
	
	Candidate getByIdentityNumber(@Param("identityNumber") String identityNumber);
}

package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	Employer getByEmail(String email);
	
	/*
	 * @Query("From Employer where id=:id") Employer getById(int id);
	 */
}

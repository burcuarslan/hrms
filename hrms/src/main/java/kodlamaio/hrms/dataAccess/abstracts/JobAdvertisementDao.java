package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(ja.id, e.companyName, jt.jobPositions, ja.openPositionCount, ja.createdDate, ja.applicationDeadline)"
			+ "From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.jobTitle jt")
	List<JobAdvertisementDto> jobAdvertisementDetails();
	
	@Query("From JobAdvertisement WHERE isActive=true")
	List<JobAdvertisement> getActiveJobAdvertisement();
	
	@Query("From JobAdvertisement where employer.companyName=:companyName AND isActive=true")
	List<JobAdvertisement> getByCompanyNameAndActiveJobAdvertisement(String companyName);
	
}

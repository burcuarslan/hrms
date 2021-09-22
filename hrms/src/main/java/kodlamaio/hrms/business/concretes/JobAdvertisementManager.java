package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.data.domain.Sort;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> jobAdvertisementDetails(){
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.jobAdvertisementDetails(), "Data başarıyla listelendi!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisement() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getActiveJobAdvertisement(), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByCompanyNameAndActiveJobAdvertisement(String companyName) {
		
	 return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCompanyNameAndActiveJobAdvertisement(companyName), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByCreatedDate() {
		Sort sort=Sort.by(Sort.Direction.DESC,"createdDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort), "Data Listelendi");
	}

	@Override
	public Result setIsActive(int id) {
		JobAdvertisement jobAdvertisement=this.jobAdvertisementDao.getById(id);
		jobAdvertisement.setIsActive(!jobAdvertisement.getIsActive());
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("işlem başarılı");
	}


	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Başarıyla eklendi");
	}

	

}

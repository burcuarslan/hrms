package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	
	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		if (!checkIfAgainPosition(jobTitle.getJobPositions())) {
			return new ErrorDataResult<JobTitle>("aynı pozisyon zaten var");
		} else {
			this.jobTitleDao.save(jobTitle);
			return new SuccessResult("pozisyon eklendi"); 
		}
		
	}
	
	@Override
	public DataResult<JobTitle> getByJobPositions(String jobPositions) {
		if (!checkIfAgainPosition(jobPositions)) {
			return new SuccessDataResult<JobTitle>(this.jobTitleDao.getByJobPositions(jobPositions),"Data listelendi");
		} else {
			return new ErrorDataResult<JobTitle>("Pozisyon bulunamadı");
		}
		
	}
	
	public boolean checkIfAgainPosition(String jobPosition) {
		if (this.jobTitleDao.getByJobPositions(jobPosition)!=null) {
			return false;
		} else {
			return true;
		}
	}

	

}

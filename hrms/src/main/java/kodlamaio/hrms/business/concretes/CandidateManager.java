package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;


@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
		
	}


	
	@Override
	public DataResult<List<Candidate>>  getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data Listelendi") ;
	}

	@Override
	public Result add(Candidate candidate) {
		if (checkIfEmailExist(candidate.getEmail())) {
			this.candidateDao.save(candidate);
			return new SuccessResult("Kişi eklendi");
		} else {
			
			return new ErrorResult("Aynı e postayla başka bir kayıt var veya tcno yanlış");
		}
		
		
	}
	

	@Override
	public DataResult<Candidate> getByEmail(String email) {
		if (checkIfEmailExist(email)) {
			return new SuccessDataResult<Candidate>(this.candidateDao.getByEmail(email),"Data Listelendi");
		} else {
			return new ErrorDataResult<Candidate>("Kullanıcı bulunamadı");
		}
		
	}
	
	/*
	 * public boolean checkIfRealPerson(Candidate candidate) { if
	 * (!this.userCheckService.checkIfRealPerson(candidate)) { return false; } else
	 * { return true; } }
	 */
	
	public boolean checkIfEmailExist(String email) {
		if (this.candidateDao.getByEmail(email)!=null) {
			return false;
		} else {
			return true;
		}
	}




}

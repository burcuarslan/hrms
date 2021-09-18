package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.UserCheckService;
import kodlamaio.hrms.core.emailValidation.CheckIfValidationEmail;
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
	private UserCheckService userCheckService;
	private CheckIfValidationEmail checkIfValidationEmail;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserCheckService userCheckService, CheckIfValidationEmail checkIfValidationEmail) {
		super();
		this.candidateDao = candidateDao;
		this.userCheckService=userCheckService;
		this.checkIfValidationEmail=checkIfValidationEmail;
		
	}

	@Override
	public DataResult<List<Candidate>>  getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data Listelendi") ;
	}

	@Override
	public Result add(Candidate candidate) {
		
		if (!checkIfEmailExist(candidate.getEmail())) {
			return new ErrorResult("Aynı e postayla başka bir kayıt var");
		} else if(!checkIfReal(candidate)){
			return new ErrorResult("tc no hatalı");
		}
		else if(!checkIfIdentityNumberExist(candidate.getIdentityNumber())){
			return new ErrorResult("bu tc no ile kayıt zaten var");
		}
		else if(!candidate.getPassword().equals(candidate.getPasswordRepeat())){
			return new ErrorResult("girilen şifreler aynı değil");
		}
		else if(!this.checkIfValidationEmail.checkValidation(candidate.getEmail())){
			return new ErrorResult("e mail onaylanmamış");
		}
		
		else {
			this.candidateDao.save(candidate);
			return new SuccessResult("Kişi eklendi");
			
		}
		
		
	}
	

	/*
	 * @Override public DataResult<Candidate> getByEmail(String email) { if
	 * (!checkIfEmailExist(email)) { return new
	 * SuccessDataResult<Candidate>(this.candidateDao.getByEmail(email)
	 * ,"Data Listelendi"); } else { return new
	 * ErrorDataResult<Candidate>("Kullanıcı bulunamadı"); }
	 * 
	 * }
	 * 
	 * @Override public DataResult<Candidate> getByIdentityNumber(String
	 * identityNumber) { if (!checkIfIdentityNumberExist(identityNumber)) { return
	 * new SuccessDataResult<Candidate>(this.candidateDao.getByIdentityNumber(
	 * identityNumber), "Data Listelendi"); } else { return new
	 * ErrorDataResult<Candidate>("Kullanıcı bulunamadı"); } }
	 */

	
	
	public Boolean checkIfEmailExist(String email) {
		if (this.candidateDao.getByEmail(email)!=null) {
			return false;
		} else {
			return true;
		}
	}
	
	public Boolean checkIfReal(Candidate candidate) {
		
		if (this.userCheckService.checkIfRealPerson(candidate).isSucces()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean checkIfIdentityNumberExist(String identityNumber) {
		if (this.candidateDao.getByIdentityNumber(identityNumber)!=null) {
			return false;
		} else {
			return true;
		}
	}
	
	

	
	


}

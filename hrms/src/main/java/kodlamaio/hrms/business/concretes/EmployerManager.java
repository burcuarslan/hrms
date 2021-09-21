package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.emailValidation.CheckIfValidationEmail;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private CheckIfValidationEmail checkIfValidationEmail;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, CheckIfValidationEmail checkIfValidationEmail) {
		super();
		this.employerDao = employerDao;
		this.checkIfValidationEmail=checkIfValidationEmail;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(Employer employer,String passwordRepeat) {
		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebAddress())) {
			return new ErrorResult("web sitesinin domaini ile email adresi uyuşmuyor");
		} else if (!employer.getPassword().equals(passwordRepeat)) {
			return new ErrorResult("girilen şifreler aynı değil");
		}
		else if(!this.checkIfValidationEmail.checkValidation(employer.getEmail())){
			return new ErrorResult("e mail onaylanmamış");
		}
		else if (!checkIfEmailExist(employer.getEmail())) {
			return new ErrorResult("Aynı e postayla başka bir kayıt var");
		}
		else {
			this.employerDao.save(employer);
			return new SuccessResult("İşlem başarılı sistem personelinin onayını bekliyor");
		}
		
	}
	
	@Override
	public Result update(Employer employer,String passwordRepeat) {
		
		employer.setIsConfirm(false);
		this.employerDao.save(employer);
		return new SuccessResult("Güncelleme başarılı sistem personelinin onayını bekliyor");
	
	}
	
	@Override
	public Result confirmEmployer(int id) {
		
		Employer employer=employerDao.getById(id);
		employer.setIsConfirm(true);
		employer.setIsActive(true);
		this.employerDao.save(employer);
		return new SuccessResult("Onaylama başarılı");
	}


	
    private Boolean checkIfEqualEmailAndDomain(String email, String website) {
        String emailArr = email.split("@")[1];
        String domain = website.substring(4, website.length());

        if (emailArr.equals(domain)) {

            return true;
        }

        return false;
    }
    
    public Boolean checkIfEmailExist(String email) {
		if (this.employerDao.getByEmail(email)!=null) {
			return false;
		} else {
			return true;
		}
	}


	
}

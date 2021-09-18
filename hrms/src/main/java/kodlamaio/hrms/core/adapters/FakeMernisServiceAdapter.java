package kodlamaio.hrms.core.adapters;



import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class FakeMernisServiceAdapter implements UserCheckService { 

	
	  @Override public Result checkIfRealPerson(Candidate candidate) {
	  
	  if (candidate.getIdentityNumber().length()!=11) { return new
	  ErrorResult("tc no geçerli değil"); } else { return new
	  SuccessResult("Doğrulama basarılı"); }
	  
	  }
	 

}

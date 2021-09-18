package kodlamaio.hrms.core.emailValidation;

import org.springframework.stereotype.Service;

@Service
public class EmailValidationManager implements CheckIfValidationEmail{

	@Override
	public Boolean checkValidation(String email) {
		
		return true;
	}

}

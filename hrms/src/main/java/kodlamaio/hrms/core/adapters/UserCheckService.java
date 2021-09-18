package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface UserCheckService {
	
	Result checkIfRealPerson(Candidate candidate);
}

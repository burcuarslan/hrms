package kodlamaio.hrms.core.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

//@Service
public class MernisServiceAdapter { //implements UserCheckService

	/*
	 * @Override public Result checkIfRealPerson(Candidate candidate) {
	 * KPSPublicSoapProxy kpsPublicSoapProxy=new KPSPublicSoapProxy(); boolean
	 * result=false; try {
	 * result=kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(candidate.
	 * getIdentityNumber()), candidate.getFirstName(), candidate.getLastName(),
	 * candidate.getYearOfBirth().getYear()); } catch (NumberFormatException |
	 * RemoteException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * }
	 * 
	 * if (result) { return new SuccessResult(); } else { return new
	 * ErrorResult("kimlik doğrulama basarısız"); }
	 * 
	 * }
	 */

	
}

package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/jobAdvertisementDetails")
	public DataResult<List<JobAdvertisementDto>> jobAdvertisementDetails(){
		return this.jobAdvertisementService.jobAdvertisementDetails();
	}
	
	@GetMapping("/getActiveJobAdvertisement")
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisement(){
		
		return this.jobAdvertisementService.getActiveJobAdvertisement();
	}
	
	@GetMapping("/getByCompanyNameAndActiveJobAdvertisement")
	public DataResult<List<JobAdvertisement>> getByCompanyNameAndActiveJobAdvertisement(@RequestParam String companyName){
		
		return this.jobAdvertisementService.getByCompanyNameAndActiveJobAdvertisement(companyName);
	}
	
	@GetMapping("/getAllSortedByCreatedDate")
	public DataResult<List<JobAdvertisement>> getAllSortedByCreatedDate(){
		
		return this.jobAdvertisementService.getAllSortedByCreatedDate();
	}
	
	
	@GetMapping("/setIsActive")
	public Result setIsActive(@RequestParam int id) {
		return this.jobAdvertisementService.setIsActive(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
}

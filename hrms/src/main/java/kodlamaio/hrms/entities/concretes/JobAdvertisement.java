package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisement")
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisement {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="description")
	@NotBlank
	@NotNull
	private String description;
	
	@Column(name="open_position_count")
	private int openPositionCount;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="created_date")
	private LocalDate createdDate = LocalDate.now();
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name="is_verified_by_employee", columnDefinition = "boolean default false")
	@JsonIgnore
	private Boolean isVerifiedByEmployee = false;
	
	@Column(name="is_active", columnDefinition = "boolean default true")
	@JsonIgnore
	private Boolean isActive = true;
	
	@ManyToOne
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	
	  @ManyToOne
	  @JoinColumn(name="city_id") private City city;
	 
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
}

package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper =false )
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")
public class Employer extends User {

	@Column(name="id")
	@JsonIgnore
	private int id;
	
	
	@Column(name="company_name")
	@NotBlank
	@NotNull
	private String companyName;
	
	@Column(name="web_address")
	@NotBlank
	@NotNull
	private String webAddress;
	
	@Column(name="phone_number")
	@NotBlank
	@NotNull
	private String phoneNumber;
	
	@NotBlank
	@NotNull
	private String passwordRepeat;
}

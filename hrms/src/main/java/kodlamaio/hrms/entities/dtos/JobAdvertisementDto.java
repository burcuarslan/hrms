package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private int id;
	private String companyName;
	private String jobPosition;
	private int openPositionCount;
	private LocalDate createdDate;
	private LocalDate applicationDeadline;
}

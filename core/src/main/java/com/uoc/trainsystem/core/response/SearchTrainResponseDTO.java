package com.uoc.trainsystem.core.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchTrainResponseDTO {

	private Long id;
	private String trainName;
	private Integer trainNo;
	private String trainType;
	private String startTime;
	private String endTime;
	private String description;
	
}

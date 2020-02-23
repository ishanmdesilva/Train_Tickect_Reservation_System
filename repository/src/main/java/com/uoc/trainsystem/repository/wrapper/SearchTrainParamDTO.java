package com.uoc.trainsystem.repository.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchTrainParamDTO {

	private Integer startStationId;
	private Integer endStationId;
	
}

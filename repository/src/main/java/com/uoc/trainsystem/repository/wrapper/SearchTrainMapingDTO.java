package com.uoc.trainsystem.repository.wrapper;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "SearchTrainMapping" , entities = {
		@EntityResult(entityClass = SearchTrainMapingDTO.class , fields = {
				@FieldResult(name = "id" , column = "id"),
				@FieldResult(name = "trainName" , column = "train_name"),
				@FieldResult(name = "trainNo" , column = "train_no"),
				@FieldResult(name = "trainType" , column = "t_type"),
				@FieldResult(name = "startTime" , column = "start_time"),
				@FieldResult(name = "endTime" , column = "end_time"),
				@FieldResult(name = "description" , column = "description"),
		})
})

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SearchTrainMapingDTO {

	@Id
	private Long id;
	private String trainName;
	private Integer trainNo;
	private String trainType;
	private String startTime;
	private String endTime;
	private String description;
	
}

package com.epam.firstaid.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDTO {

  @JsonProperty("employee")
  private EmployeeDTO employeeDTO;

  @JsonProperty("approver")
  private ApproverDTO approverDTO;

  private Long id;

  @JsonProperty("type")
  private TypeDTO typeDTO;

  private Long duration;

  @JsonProperty("status")
  private StatusDTO statusDTO;

  private Long endDate;

  private Long startDate;

  private Long processInstanceId;

  private String vacationForm;

  private boolean confirmativeDocumentAvailable;

}

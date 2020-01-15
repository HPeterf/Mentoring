package com.epam.firstaid.dto.response;

import com.epam.firstaid.dto.DataDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDTO {

  private String status;

  @JsonProperty("data")
  private List<DataDTO> dataDTOList;

}

package com.simplon.labxpert.model.entity;

import com.simplon.labxpert.model.enums.ResultStatus;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "results")
public class Result {

  @Id
  @SequenceGenerator(
      name = "result_id_sequence",
      sequenceName = "result_id_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "result_id_sequence")
  @Column(name = "resultID")
  private long resultID;

  @Column(name = "resultValues")
  private double resultValues;

  @Column(name = "measurementUnits")
  private String measurementUnits;

  @Enumerated(EnumType.STRING)
  private ResultStatus resultStatus;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "analysis_id")
  private Analysis analysis;
}

package com.simplon.labxpert.model.entity;

import com.simplon.labxpert.model.enums.SampleStatus;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "samples")
public class Sample {
  @Id
  @SequenceGenerator(
      name = "sample_id_sequence",
      sequenceName = "sample_id_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_id_sequence")
  private long sampleID;

  @Column(name = "analysisType")
  private String analysisType;

  @Column(name = "sampleDescription")
  private String sampleDescription;

  @Column(name = "collectionDate")
  private LocalDate collectionDate;

  @Enumerated(EnumType.STRING)
  private SampleStatus sampleStatus = SampleStatus.PENDING;

  @ManyToOne
  @JoinColumn(name = "patient_id")
  private Patient patient;

  @OneToMany(mappedBy = "sample")
  private List<Analysis> analyses;
}

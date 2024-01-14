package com.simplon.labxpert.model.entity;

import com.simplon.labxpert.model.enums.Priority;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "schedulings")
public class Scheduling {
  @Id
  @SequenceGenerator(
      name = "scheduling_id_sequence",
      sequenceName = "scheduling_id_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scheduling_id_sequence")
  private long schedulingID;

  @Column(name = "startDateAndTime")
  private LocalDate startDateAndTime;

  @Column(name = "endDateAndTime")
  private LocalDate endDateAndTime;

  @Enumerated(EnumType.STRING)
  private Priority priority;

  @Column(name = "notes")
  private String notes;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "analysis_id")
  private Analysis analysis;
}

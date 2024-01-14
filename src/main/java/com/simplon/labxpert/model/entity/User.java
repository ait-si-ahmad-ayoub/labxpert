package com.simplon.labxpert.model.entity;

import com.simplon.labxpert.model.enums.UserRole;
import com.sun.istack.NotNull;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
  @Id
  @SequenceGenerator(
      name = "user_id_sequence",
      sequenceName = "user_id_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_sequence")
  @Column(name = "userID")
  private long userID;

  @NotNull
  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "emailVerified")
  private Boolean emailVerified = false;

  @NotNull
  @Column(name = "username", unique = true)
  private String username;

  @NotNull
  @Column(name = "password")
  private String password;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(name = "userRole")
  private UserRole userRole;

  @NotNull
  @Column(name = "personalInfo")
  private String personalInfo;

  @OneToMany(mappedBy = "user")
  private List<Scheduling> schedulings;

  @OneToMany(mappedBy = "user")
  private List<Analysis> analyses;
}

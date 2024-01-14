package com.simplon.labxpert.repository;

import com.simplon.labxpert.model.entity.Reagent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReagentRepository extends JpaRepository<Reagent, Long> {}

package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.model.SectionDB;

@Repository
public interface ISectionDao extends JpaRepository<SectionDB, Integer> {

}

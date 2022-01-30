package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.model.LevelDB;

@Repository
public interface ILevelDao extends JpaRepository<LevelDB, Integer> {

}

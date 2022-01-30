package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.model.AchedemicFeeDB;

public interface IAchedemicFeeDao extends JpaRepository<AchedemicFeeDB,String> {

}

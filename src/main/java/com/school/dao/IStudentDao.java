package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.model.StudentDB;

@Repository
public interface IStudentDao extends JpaRepository<StudentDB, String> {

}

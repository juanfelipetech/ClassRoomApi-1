package com.example.ClassRoomApi.repositories;

import com.example.ClassRoomApi.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher,Integer> {
    
}

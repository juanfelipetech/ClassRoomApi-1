package com.example.ClassRoomApi.services;

import com.example.ClassRoomApi.models.Teacher;
import com.example.ClassRoomApi.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired //Inyección de dependencias
    ITeacherRepository repository;

    //En el servicio implementamos los métodos que necesitemos según los servicios a ofrecer

    //GUARDAR
    public Teacher guardarTeacher(Teacher dataTeacher)throws Exception{
        try{
            return this.repository.save(dataTeacher);
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //MODIFICAR

    //BUSCAR POR ID

    //BUSCAR TODOS

    //ELIMINAR



}

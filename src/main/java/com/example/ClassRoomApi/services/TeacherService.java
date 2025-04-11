package com.example.ClassRoomApi.services;

import com.example.ClassRoomApi.helpers.MensajeAPI;
import com.example.ClassRoomApi.models.Teacher;
import com.example.ClassRoomApi.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired //Inyección de dependencias
    ITeacherRepository repository;

    //En el servicio implementamos los métodos que necesitemos según los servicios a ofrecer

    //GUARDAR
    public Teacher saveTeacher(Teacher dataTeacher)throws Exception{
        try{
            return this.repository.save(dataTeacher);
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //MODIFICAR
    public Teacher modifyTeacher(Integer id,Teacher dataTeacher)throws Exception{
        try {
            //Para modificar primero debo buscar
            //JPA me devuelve un dato opcional (puede estar o no)
            Optional<Teacher> searchedTeacher = this.repository.findById(id);
            //Apenas lo busqués pregunta si si está
            if(searchedTeacher.isPresent()){
                //Modifiquelo pues papá
                searchedTeacher.get().setExpertise(dataTeacher.getExpertise());
                return this.repository.save(searchedTeacher.get());
            }else{
                //No estaba el muñeco
                throw new Exception(MensajeAPI.TEACHER_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }

    //BUSCAR POR ID
    public Teacher searchTeacherById(Integer id)throws Exception{
        try{
            Optional<Teacher> searchedTeacher = this.repository.findById(id);
            if (searchedTeacher.isPresent()){
                //Retorno el docente que busco
                return searchedTeacher.get();
            }else{
                //Mensaje que no está
                throw new Exception(MensajeAPI.TEACHER_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //BUSCAR TODOS
    public List<Teacher> searchAllTeacher()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //ELIMINAR
    public boolean eliminateTeacher(Integer id)throws Exception{
        try{
          Optional<Teacher> searchedTeacher = this.repository.findById(id);
          if (searchedTeacher.isPresent()){
              this.repository.deleteById(id);
              return true;
          }else{
              throw new Exception(MensajeAPI.TEACHER_NOT_FOUND.getText());
          }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }


}

package com.example.ClassRoomApi.Controllers;

import com.example.ClassRoomApi.models.Teacher;
import com.example.ClassRoomApi.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherService service;

    //Controlador para guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Teacher dataSentByClient){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveTeacher(dataSentByClient));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }
    }

    //Controlador para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Teacher data){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.modifyTeacher(id, data));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }
    //Controlador para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.searchTeacherById(id));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }
    }
    //Controlador para buscarlos todos
    @GetMapping
    public ResponseEntity<?> searchAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.searchAllTeacher());
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }
    //Controlador para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.deleteTeacher(id));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }

}

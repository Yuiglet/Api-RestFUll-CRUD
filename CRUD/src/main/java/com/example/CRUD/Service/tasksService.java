package com.example.CRUD.Service;

import com.example.CRUD.Model.tasksModel;
import com.example.CRUD.Repository.tasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@Service
public class tasksService {

    private final tasksRepository TasksRepository;
    @Autowired
    public tasksService(tasksRepository TasksRepository){
        this.TasksRepository = TasksRepository;
    }
    @GetMapping
    public List<tasksModel> getTasks(){

        return TasksRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Object> NewTask (tasksModel TasksModel){
        Optional<tasksModel> res = TasksRepository.findTaskBynomTarea(TasksModel.getNomTarea());
        HashMap<String,Object> info = new HashMap<>();
        if (res.isPresent()){
            info.put("error: ", true);
            info.put("mensaje: ", "Tarea duplicada");
            return new ResponseEntity<>(
                    info,
                    HttpStatus.CONFLICT
            );
        }
        TasksRepository.save(TasksModel);
        info.put("Mensaje: ", "Datos guardados correctamente");
        info.put("registro: ", TasksModel);
        return new ResponseEntity<>(
          info,
          HttpStatus.CREATED
        );
    }
    @PutMapping
    public ResponseEntity<Object> UpdateTask ( Long id, tasksModel updatedTask){
        Optional<tasksModel> existingTask = TasksRepository.findById(id);

        if (existingTask.isPresent()) {
            tasksModel taskToUpdate = existingTask.get();
            taskToUpdate.setNomTarea(updatedTask.getNomTarea());
            taskToUpdate.setDescripcionTarea(updatedTask.getDescripcionTarea());
            taskToUpdate.setEstadoTarea(updatedTask.getEstadoTarea());

            TasksRepository.save(taskToUpdate);

            HashMap<String, Object> info = new HashMap<>();
            info.put("Mensaje: ", "Tarea actualizada correctamente");
            info.put("registro: ", taskToUpdate);
            return new ResponseEntity<>(
                    info,
                    HttpStatus.OK
            );
        } else {
            HashMap<String, Object> info = new HashMap<>();
            info.put("error: ", true);
            info.put("mensaje: ", "Tarea no encontrada");
            return new ResponseEntity<>(
                    info,
                    HttpStatus.NOT_FOUND
            );
        }
    }
    @DeleteMapping
    public ResponseEntity<Object> DeleteTask ( Long id){
        Optional<tasksModel> existingTask = TasksRepository.findById(id);

        if (existingTask.isPresent()) {
            tasksModel taskToDelete = existingTask.get();
            TasksRepository.delete(taskToDelete);

            HashMap<String, Object> info = new HashMap<>();
            info.put("Mensaje: ", "Tarea eliminada correctamente");
            return new ResponseEntity<>(
                    info,
                    HttpStatus.OK
            );
        } else {
            HashMap<String, Object> info = new HashMap<>();
            info.put("error: ", true);
            info.put("mensaje: ", "Tarea no encontrada");
            return new ResponseEntity<>(
                    info,
                    HttpStatus.NOT_FOUND
            );
        }
    }
}

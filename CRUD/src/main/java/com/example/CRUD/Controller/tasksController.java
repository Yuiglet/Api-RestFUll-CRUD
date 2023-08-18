package com.example.CRUD.Controller;

import com.example.CRUD.Service.tasksService;
import com.example.CRUD.Model.tasksModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tareas")
public class tasksController {
    private final tasksService TasksService;

    @Autowired
    public tasksController(tasksService TasksService) {
        this.TasksService = TasksService;
    }
    @GetMapping
    public List<tasksModel> getTasks(){
        return TasksService.getTasks();
    }
    @PostMapping (path = "/regTarea")
    public ResponseEntity<Object> newTask(@RequestBody tasksModel TasksModel){
         return this.TasksService.NewTask(TasksModel);
    }
    @PutMapping (path = "/actuTarea/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable Long id, @RequestBody tasksModel TasksModel){
        return this.TasksService.UpdateTask(id,TasksModel);
    }
    @DeleteMapping (path = "/borrarTarea/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable Long id){
        return this.TasksService.DeleteTask(id);
    }
}

package com.example.CRUD.Repository;

import com.example.CRUD.Model.tasksModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface tasksRepository extends JpaRepository<tasksModel, Long> {
     Optional <tasksModel> findTaskBynomTarea(String nomTarea);
}

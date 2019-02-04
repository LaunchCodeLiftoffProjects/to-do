package org.launchcode.todo.models.data;


import org.launchcode.todo.models.AddTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AddTaskDao extends CrudRepository <AddTask, String> {
}

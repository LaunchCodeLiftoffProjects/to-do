package org.launchcode.todo.models.data;


//import org.launchcode.todo.models.AddEvent;
import org.launchcode.todo.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
//import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AddEventDao extends CrudRepository <Event, Integer> {


}

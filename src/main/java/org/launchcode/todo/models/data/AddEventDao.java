package org.launchcode.todo.models.data;


//import org.launchcode.todo.models.AddEvent;
import org.launchcode.todo.models.Event;
import org.launchcode.todo.models.User;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.metamodel.SingularAttribute;
import javax.transaction.Transactional;
//import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public interface AddEventDao extends CrudRepository <Event, Integer> {

List<Event> findByUser(User user);


}

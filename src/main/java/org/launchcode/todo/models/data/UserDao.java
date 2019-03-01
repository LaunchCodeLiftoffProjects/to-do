package org.launchcode.todo.models.data;

import org.launchcode.todo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional

public interface UserDao extends CrudRepository<User,String>{
}

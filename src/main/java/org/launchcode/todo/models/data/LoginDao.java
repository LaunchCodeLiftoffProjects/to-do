package org.launchcode.todo.models.data;

import org.launchcode.todo.models.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LoginDao extends CrudRepository<Login,String> {

}
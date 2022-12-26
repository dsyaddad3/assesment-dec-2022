package com.corpora.assesment.repository;

import org.springframework.data.repository.CrudRepository;

import com.corpora.assesment.entity.User;

public interface UserRepo extends CrudRepository<User,String> {

}

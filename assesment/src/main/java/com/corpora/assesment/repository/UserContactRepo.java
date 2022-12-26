package com.corpora.assesment.repository;


import org.springframework.data.repository.CrudRepository;

import com.corpora.assesment.entity.UserContact;

public interface UserContactRepo extends CrudRepository<UserContact,String>{
    
}

package com.corpora.assesment.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.corpora.assesment.entity.User;
import com.corpora.assesment.entity.UserContact;
import com.corpora.model.UserContactVO;

@Service
public interface UserService {
    User getUserById(String id);
    UserContact getUserContactById(String id);
    void saveUserAndContact(UserContactVO user);
    void deleteUserAndContact(String id);
    List<User> getUsers();
    List<UserContact> getUserContacts();
    UserContactVO getUserAndContactByUserId(String id);
}

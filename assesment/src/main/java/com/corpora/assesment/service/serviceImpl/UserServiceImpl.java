package com.corpora.assesment.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corpora.assesment.entity.User;
import com.corpora.assesment.entity.UserContact;
import com.corpora.assesment.repository.UserContactRepo;
import com.corpora.assesment.repository.UserRepo;
import com.corpora.assesment.service.UserService;
import com.corpora.model.UserContactVO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired 
    private UserContactRepo userContactRepo;

    @Override
    public User getUserById(String id) {
        // TODO Auto-generated method stub
        return unwarpUser(userRepo.findById(id), id);
    }

    @Override
    public void saveUserAndContact(UserContactVO vo) {
        // TODO Auto-generated method stub
        User user = new User(vo.getId(), vo.getName(), vo.getAge());
        UserContact userContact = new UserContact((vo.getName()+vo.getId()), vo.getAddress(), user);
        userRepo.save(user);
        userContactRepo.save(userContact);
    }

    @Override
    public void deleteUserAndContact(String id) {
        // TODO Auto-generated method stub
        userRepo.deleteById(id);
        userContactRepo.deleteById(id);
    }

    private User unwarpUser(Optional<User> entity, String id){
        if(entity.isPresent()) return entity.get();
        else return null;
    }
    private UserContact unwarpUserContact(Optional<UserContact> entity, String id){
        if(entity.isPresent()) return entity.get();
        else return null;
    }

    @Override
    public UserContactVO getUserAndContactByUserId(String id) {
        // TODO Auto-generated method stub
        User user = getUserById(id);
        try {
            UserContact userContact = unwarpUserContact(userContactRepo.findById(user.getId()), id);
            UserContactVO out = new UserContactVO(user.getId(), user.getName(), user.getAge(), userContact.getAddress());
            return out;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserContact getUserContactById(String id) {
        // TODO Auto-generated method stub
        return unwarpUserContact(userContactRepo.findById(id), id);
    }

    @Override
    public List<User> getUsers() {
        // TODO Auto-generated method stub
        return (List<User>)userRepo.findAll();
    }

    @Override
    public List<UserContact> getUserContacts() {
        // TODO Auto-generated method stub
        return (List<UserContact>)userContactRepo.findAll();
    }
    
}

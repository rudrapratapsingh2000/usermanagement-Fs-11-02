package com.usermanagement.service;

import com.usermanagement.model.UserModels;
import com.usermanagement.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;

    public String addUser(UserModels user) {
        iUserRepo.save(user);
        return user.getUserName()+" added Successfully";
    }

    public UserModels getUser(Integer number) {
        UserModels user=iUserRepo.findById(number).get();
        return user;
    }

    public List<UserModels> getAllUser() {
        return iUserRepo.findAll();
    }

    public String deleteUser(Integer number) {
        iUserRepo.deleteById(number);
        return "user deleted Successfully";
    }

    public String updateUserInfo(Integer number, UserModels user) {
        UserModels user1=iUserRepo.findById(number).get();
        if(user1!=null){
            user1.setUserId(user.getUserId());
            user1.setEmail(user.getEmail());
            user1.setUserName(user.getUserName());
            user1.setPhoneNumber(user.getPhoneNumber());
            user1.setDateOfBirth(user.getDateOfBirth());
        }
        else{
            iUserRepo.save(user);
        }
        return "User Updated";
    }
}

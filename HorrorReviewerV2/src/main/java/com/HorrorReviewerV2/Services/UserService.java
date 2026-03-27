package com.HorrorReviewerV2.Services;

import com.HorrorReviewerV2.Entities.User;
import com.HorrorReviewerV2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> getAllusers(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public User postUser(User newUser){
        return userRepository.save(newUser);
    }

    public User UpdateUser(User user, Integer id){
        if(userRepository.existsById(id)){
            user.setId(id);
            return userRepository.save(user);
        }else{
            return null;
        }
    }

    public Boolean deleteUser(Integer id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}

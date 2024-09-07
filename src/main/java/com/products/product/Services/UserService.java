package com.products.product.Services;

import com.products.product.Models.User;
import com.products.product.Repos.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public String auth(User p) {
        if(userRepo.existsById(p.getEmail())){
            User existingUser = userRepo.findById(p.getEmail()).get();
            if((existingUser.getPassword().equals(p.getPassword())) && (existingUser.getEmail().equals(p.getEmail()))){
                return "{\n    \"email\" : \""+p.getEmail()+"\",\n    \"status\" : \"success\"\n}";
            }else{
                return "{\n    \"email\" : \""+p.getEmail()+"\",\n    \"status\" : \"failed\"\n}";
            }
            
        }else{
            return "{\n    \"email\" : \""+p.getEmail()+"\",\n    \"status\" : \"No account Found\"\n}";
        }

    }

    public void registerUser(User p) {
        if(userRepo.existsById(p.getEmail())){
            return ;
        }
        userRepo.save(p);
        return;
    }

    public User update(User p) {
        User existingUser = userRepo.findById(p.getEmail()).get();
        BeanUtils.copyProperties(p,existingUser,p.getEmail());
        return userRepo.save(existingUser);
    }
}

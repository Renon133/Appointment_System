package peoplestrong.team7.appointmentApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import peoplestrong.team7.appointmentApp.Models.User;
import peoplestrong.team7.appointmentApp.Repository.UserRepository;
import java.util.*;

@Service
public class ChangePasswordService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String changePassword(String oldPassword, String newPassword, String emailID){

        Optional<User> userOptional = userRepo.findByEmail(emailID);
        try{
            if(userOptional.isPresent()) {
                User user = userOptional.get();
                System.out.println(oldPassword + ": is the raw password");

                if(passwordEncoder.matches(oldPassword, user.getPassword())) {
                    user.setPassword(passwordEncoder.encode(newPassword));
                    System.out.println(newPassword + ": Password Changed Successfully");
                    userRepo.save(user);
                }else{
                    System.out.println("Password do not match");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            return "Password Saved";
        }

//        System.out.println(authentication.getDetails());
//        System.out.println(authentication.getCredentials());
//        System.out.println((UserDetails) authentication.getPrincipal());
//        User tempUser = userRepo.findByEmail(authentication.).get();
//        System.out.println(tempUser.getPassword());
//        tempUser.setPassword(passwordEncoder.encode(newPassword));
//        userRepo.save(tempUser);
    }





}

package peoplestrong.team7.appointmentApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peoplestrong.team7.appointmentApp.Exception.UserAlreadyExistsException;
import peoplestrong.team7.appointmentApp.Models.PasswordObject;
import peoplestrong.team7.appointmentApp.Models.User;
import peoplestrong.team7.appointmentApp.Repository.UserRepository;
import peoplestrong.team7.appointmentApp.Services.ChangePasswordService;
import peoplestrong.team7.appointmentApp.Services.RegistrationService;

@RestController
public class ApiController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegistrationService regstService;

    @GetMapping(value = "/")
    public ModelAndView viewHomePage() {
        ModelAndView modelAndView = new ModelAndView("index.html");
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public String signUpForm(Model model) {
        model.addAttribute(new User());
        return "SignupForm";
    }

    @RequestMapping(value = "/processRegistration", method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> processRegistration(@RequestBody User user) throws UserAlreadyExistsException {
            String msg = regstService.processRegistration(user);
            return ResponseEntity.ok(msg);
    }

//    @PostMapping("/login")
//    public String loginUser(@RequestBody User user) {
//        User oAuthUser = userRepository.findByEmail(user.getEmail()).get();
////        System.out.println(oAuthUser.getPassword() + " && " + user.getPassword() );
//        if(oAuthUser == null) {
//            return "Invalid Credentials";
//        }else{
//            if(user.getPassword().contentEquals(oAuthUser.getPassword())) {
//                return "Login Successful";
//            }else{
//                return "Invalid Credentials";
//            }
//        }
//    }
    @RequestMapping("/login")
    public String loginPage(){
        return "Login Page";
    }

    @RequestMapping(value = "/login-success", method = RequestMethod.GET)
    public String loginSuccessPage() {
        return "Login SuccessFul";
    }

    @RequestMapping("/logout")
    public String logoutPage(){
        return "Processing Logout";
    }

    @RequestMapping("/logout-success")
    public String logoutSuccessPage() {
        return "Logout SuccessFul";
    }


    @Autowired
    private ChangePasswordService changePasswordService;
    @RequestMapping("/user/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody PasswordObject object) {
        String result = changePasswordService.changePassword(object.getOldPassword(), object.getNewPassword(), object.getEmailID());
        return ResponseEntity.ok(result);
    }
}

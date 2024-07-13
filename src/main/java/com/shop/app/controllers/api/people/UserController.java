package com.shop.app.controllers.api.people;

import com.shop.app.config.JwtTokenUtil;
import com.shop.app.entities.people.User;
import com.shop.app.helper.ui.ResponseStatus;
import com.shop.app.helper.ui.ServiceResponse;
import com.shop.app.helper.uimodels.people.UserVM;
import com.shop.app.services.people.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;


@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService service;
/*  @Autowired
    private JwtTokenUtil jwtTokenUtil;*/


 /*   @PostMapping("/login")
    public ServiceResponse<UserVM> login(@RequestBody User user)
            throws NoSuchAlgorithmException {
        User userData = service.auth(user.getUsername(), user.getPassword());
        if (userData == null) {
            return new ServiceResponse<>(ResponseStatus.FAILED, "Incorrect Username or Password!");
        }
        UserVM userVM = new UserVM(userData);
        //todo set token
        String token = jwtTokenUtil.generateToken(userVM);
        userVM.setToken(token);
        return new ServiceResponse<>(ResponseStatus.SUCCESS, userVM);
    }*/

 @PostMapping("/login")
    public ServiceResponse<UserVM> login(@RequestBody User user){
        User userData = service.auth(user.getUsername(), user.getPassword());

        if (userData == null) {
            return new ServiceResponse<>(ResponseStatus.FAILED,
                    "Incorrect Username or Password!");
        }
        UserVM userVM = new UserVM(userData);
        //todo set token
        userVM.setToken("----token----");
        return new ServiceResponse<>(ResponseStatus.SUCCESS, userVM);
    }





    @GetMapping("/newUser")
    public User newUser() {

        return new User();
    }
    @GetMapping("/get")
    public String get() {

        return new String("Miladrostami");

    }

    @GetMapping("/{id}")
    public ServiceResponse<UserVM> search(@PathVariable long id) {
        try {
            User result = service.getById(id);

            return new ServiceResponse<>(ResponseStatus.SUCCESS, new UserVM(result));
        } catch (Exception e) {

            return new ServiceResponse<>(e);
        }
    }

/*    @GetMapping("/{getUserInfo}")
    public ServiceResponse<UserVM> getUserInfo(@PathVariable String token) {
        try {
            if (token == null || token.equals("")) {
                throw new Exception("token is empty");
            }
            String username = jwtTokenUtil.getUsernameFromToken(token);
            User result = service.getByUsername(username);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, new UserVM(result));
        } catch (Exception e) {
            return new ServiceResponse<>(e);
        }
    }*/

    @PostMapping("/")
    public ServiceResponse<UserVM> add(@RequestBody User data) {
        try {
            User result = service.add(data);

            return new ServiceResponse<>(ResponseStatus.SUCCESS, new UserVM(result));
        } catch (Exception e) {

            return new ServiceResponse<>(e);

        }
    }

    @PutMapping("/")
    public ServiceResponse<UserVM> update(@RequestBody User data) {
        try {
            User result = service.update(data);
            System.out.println("test response ok");
            return new ServiceResponse<>(ResponseStatus.SUCCESS, new UserVM(result));
        } catch (Exception e) {
            System.out.println("test response not ok");
            return new ServiceResponse<>(e);
        }
    }

    @DeleteMapping("/{id}")
    public ServiceResponse<Boolean> delete(@PathVariable long id) {
        try {
            boolean result = service.deleteById(id);
            return new ServiceResponse<>(ResponseStatus.SUCCESS, result);
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }


  /*  @PostMapping("/changePass")
    public ServiceResponse<UserVM> changePassword(@RequestBody UserVM data) {
        try {
            User result = service.changePassword(data.getId(), data.getPassword(),
                    data.getNewPassword());
            return new ServiceResponse<>(ResponseStatus.SUCCESS, new UserVM(result));
        } catch (Exception e) {
            return new ServiceResponse<>(e);

        }
    }
*/
}

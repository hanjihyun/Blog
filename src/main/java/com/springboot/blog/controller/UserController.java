package com.springboot.blog.controller;

import com.springboot.blog.model.request.RequestLoginUser;
import com.springboot.blog.model.response.ResponseBasic;
import com.springboot.blog.model.user.User;
import com.springboot.blog.model.user.UserRole;
import com.springboot.blog.repository.UserRepository;
import com.springboot.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
//
//    @Autowired
//    private JwtUtil jwtUtil;

    private final UserService userService;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private static String clientId;

    @Value("${oauth.google.clientId:'100'}")
    private void setClientId(String temp) {
        clientId = temp;
    }

    @PostMapping("/tokenVerify")
    public Object tokenVerify(String idToken){
        ResponseBasic result = null;
        System.out.println(idToken);
        try {

            result = new ResponseBasic( true, "success", null);
        }
        catch (Exception e){
            result = new ResponseBasic(false, "fail", null);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/signUp")
    public Object sighUp(@RequestBody User request){
        ResponseBasic result = null;
        try {

            result = new ResponseBasic( true, "success", null);
        }
        catch (Exception e){
            result = new ResponseBasic(false, "fail", null);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
    @GetMapping("/login2")
    public Object login2(@RequestBody User userReq) {
        System.out.println("????????????????");
        System.out.println(userReq.getEmail());
        System.out.println(userReq.getPassword());

        ResponseBasic result = null;
        try {

            result = new ResponseBasic( true, "success", null);
        }
        catch (Exception e){
            result = new ResponseBasic(false, "fail", null);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/login")
    public Object login(@RequestBody User userReq, HttpServletResponse response) {
        ResponseBasic result = new ResponseBasic();

        Optional<User> userOpt = userRepository.findByEmail(userReq.getEmail());
        if(!userOpt.isPresent()){
            result = new ResponseBasic(false, "?????? ???????????? ???????????? ????????????.", null);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            User user = userOpt.get();
            if(user.getRole().equals(UserRole.GUEST)){
                result = new ResponseBasic(false, "???????????? ????????? ?????? ??? ????????? ???????????????.", null);
                return new ResponseEntity<>(result, HttpStatus.OK);
            }else if(user.getRole().equals(UserRole.WITHDRAW)) {
                result = new ResponseBasic(false, "????????? ???????????? ????????? ???????????????.", null);
                return new ResponseEntity<>(result, HttpStatus.OK);
            }else{
                if (!passwordEncoder.matches(userReq.getPassword(), user.getPassword())) {
                    result = new ResponseBasic(false, "????????? ?????????????????????.", null);
                    return new ResponseEntity<>(result, HttpStatus.OK);
                }else {

//                    final String token = jwtUtil.generateToken(user.getEmail());
//                    final String refresh = jwtUtil.generateRefreshToken(user.getEmail());
//
//                    Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
//                    Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refresh);
//                    redisUtil.setDataExpire(refresh, user.getEmail(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
//
//                    response.addCookie(accessToken);
//                    response.addCookie(refreshToken);

                    result = new ResponseBasic(true, "success", user);
                }
            }

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}

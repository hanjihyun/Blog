package com.springboot.blog.controller;

import com.springboot.blog.model.request.RequestLoginUser;
import com.springboot.blog.model.response.ResponseBasic;
import com.springboot.blog.model.user.User;
import com.springboot.blog.model.user.UserRole;
import com.springboot.blog.repository.UserRepository;
import com.springboot.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequiredArgsConstructor
@ResponseBody
public class UserController {
//
//    @Autowired
//    private JwtUtil jwtUtil;

    private final UserService userService;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @RequestMapping(value = "tokenVerify", method = RequestMethod.POST)
    public ResponseEntity<?> tokenVerify(String idToken){
        System.out.println("RequestBody value : " + idToken);

        return null;
    }

    @PostMapping("/login")
    public Object login(@RequestBody RequestLoginUser userReq, HttpServletResponse response) {
        ResponseBasic result = new ResponseBasic();

        Optional<User> userOpt = userRepository.findByEmail(userReq.getEmail());
        if(!userOpt.isPresent()){
            result = new ResponseBasic(false, "해당 이메일이 존재하지 않습니다.", null);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            User user = userOpt.get();
            if(user.getRole().equals(UserRole.GUEST)){
                result = new ResponseBasic(false, "회원가입 이메일 인증 후 로그인 가능합니다.", null);
                return new ResponseEntity<>(result, HttpStatus.OK);
            }else if(user.getRole().equals(UserRole.WITHDRAW)) {
                result = new ResponseBasic(false, "탈퇴한 회원으로 로그인 불가합니다.", null);
                return new ResponseEntity<>(result, HttpStatus.OK);
            }else{
                if (!passwordEncoder.matches(userReq.getPassword(), user.getPassword())) {
                    result = new ResponseBasic(false, "잘못된 비밀번호입니다.", null);
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

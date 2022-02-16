package com.springboot.blog.controller;

import com.springboot.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@ResponseBody
public class UserController {
    private final UserService userService;

    @RequestMapping(value = "tokenVerify", method = RequestMethod.POST)
    public ResponseEntity<?> tokenVerify(String idToken){
        System.out.println("RequestBody value : " + idToken);

        return null;
    }
}

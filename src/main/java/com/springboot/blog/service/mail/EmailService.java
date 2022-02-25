package com.springboot.blog.service.mail;

public interface EmailService {
    String sendSimpleMessage(String to)throws Exception;
}


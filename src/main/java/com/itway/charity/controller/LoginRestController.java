package com.itway.charity.controller;

import com.itway.charity.dto.ResponseDto;
import com.itway.charity.dto.UsersDto;
import com.itway.charity.entity.Users;
import com.itway.charity.service.inter.EmailServiceInter;
import com.itway.charity.service.inter.UsersServiceInter;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

@RestController
public class LoginRestController {

    @Autowired
    private UsersServiceInter usersServiceInter;

    @Autowired
    private EmailServiceInter emailServiceInter;

    @PostMapping(value = "login")
    public ResponseEntity loginUser(@RequestBody UsersDto usersDto){

        Users users = usersServiceInter.getByMailAndPassword(usersDto.getMail(),usersDto.getPassword());

        if (users!=null){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok",new UsersDto(users)));
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(404,"user not found",null));
        }
    }

    @PostMapping(value = "registration")
    public ResponseEntity registerUser(@RequestBody UsersDto usersDto) throws MessagingException {
        try{
            int id = usersServiceInter.insert(getUser(usersDto));
            Users users = usersServiceInter.getById(id);
            emailServiceInter.sendEmail(users.getMail(),"CharityApp Verification Code",
                    "Hello <br> your verification code is <br> " + users.getUserKey());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok",null));
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(404,"error",null));
        }
    }

    @PostMapping(value = "verification")
    public ResponseEntity verifyUser (@RequestBody UsersDto usersDto){
        Users users = usersServiceInter.getByMailPasswordAndKey(usersDto.getMail(),usersDto.getPassword(),usersDto.getUserKey());

        if (users != null){
            users.setUserActive((short)1);
            usersServiceInter.update(users);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok",users));
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(404,"Confirmation key is not true",null));
        }
    }

    public Users getUser(UsersDto usersDto){
        Users users = new Users();
        users.setName(usersDto.getName());
        users.setMail(usersDto.getMail());
        users.setPhoneNumber(usersDto.getPhoneNumber());
        users.setPassword(usersDto.getPassword());
        Date date = new Date();
        users.setLoginDate(date);
        users.setUserActive((short)0);
        users.setUserToken(getToken());
        users.setUserKey(getRandomKey().toString());

        return users;
    }
    public Integer getRandomKey(){
        Random random = new Random();
        Integer randomKey =  100000 + random.nextInt(900000);

        return randomKey;
    }
    public String getToken(){
        String token = UUID.randomUUID().toString().replace("-","");
        return token;
    }
}

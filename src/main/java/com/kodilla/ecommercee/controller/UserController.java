package com.kodilla.ecommercee.controller;

<<<<<<< HEAD
import com.kodilla.ecommercee.domain.users.UserDto;
=======
import com.kodilla.ecommercee.domain.user.UserDto;
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private List<UserDto> users = Collections.emptyList();

    @PostMapping(value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        users.add(userDto);
    }

    @PutMapping(value = "badUser")
    public UserDto badUser(@RequestBody Long id) {
        UserDto user = getUserForSpecificID(id);
        return user;
    }

    @GetMapping(value = "getToken", consumes = APPLICATION_JSON_VALUE)
    public Long getToken(@RequestBody Long userId){
        Random random = new Random();
        Long randomLong = random.nextLong();
        return randomLong;
    }

    private UserDto getUserForSpecificID(Long id){
        for (UserDto user:users){
            if (user.getUserId()==id){
                return user;
            }
        }
        return null;
    }

}

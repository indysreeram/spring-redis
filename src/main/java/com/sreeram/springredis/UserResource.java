package com.sreeram.springredis;

import com.sreeram.springredis.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

    private UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public  User add(@PathVariable ("id") final String id,
              @PathVariable("name") final String name
             ){
        System.out.println(id + " " + name);
        userRepository.save(new User(id,name,"Wilmington"));
        return userRepository.findBy(id);
    }

    @GetMapping("/update/{id}/{name}")
    public  User update(@PathVariable ("id") final String id,
                        @PathVariable("name") final String name
    ){
        userRepository.update(new User(id,name,"NewYork"));
        return userRepository.findBy(id);
    }


    @GetMapping("/delete/{id}")
    public  Map<String,User> delete(@PathVariable ("id") final String id){
        userRepository.delete(id);
        return userRepository.findall();
    }


    @GetMapping("/all")
    public Map<String,User> all(){

        return  userRepository.findall();

    }

}

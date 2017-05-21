package example.spring.web.service;

import example.spring.web.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Dongle (Dongkyun)
 * Date : 5/14/17
 */
@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService()    {
        for(int i = 0;i < 10;i++)    {
            users.add(new User(i, "Dennis"+i, "Kim" + i, "email" + i + "@service.com"));
        }
    }

    public List<User> findAll()   {
        return users;
    }
}

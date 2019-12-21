package app.service.impl;

import app.model.Login;
import app.model.User;
import app.service.IUserService;
import java.util.*;

public class UserServiceImpl implements IUserService {
    List<User> users;
    {
        users = new ArrayList<>();
        users.add(new User("admin","12345","Nguyễn Văn A","a@gmail.com",31));
        users.add(new User("user1","12345","Nguyễn Văn B","b@gmail.com",29));
        users.add(new User("user2","12345","Nguyễn Văn C","c@gmail.com",28));
        users.add(new User("user3","12345","Nguyễn Văn D","d@gmail.com",26));
        users.add(new User("user4","12345","Nguyễn Văn E","e@gmail.com",24));
    }

    @Override
    public User checkUser(Login login) {
        for (User u : users) {
            if(u.getAccount().equals(login.getAccount()) && u.getPassword().equals(login.getPassword())) {
                return u;
            }
        }
        return null;
    }
}

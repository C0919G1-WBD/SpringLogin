package app.service;

import app.model.Login;
import app.model.User;

import java.util.*;


public interface IUserService extends IGeneralService<User> {
    User checkUser(Login login);
}

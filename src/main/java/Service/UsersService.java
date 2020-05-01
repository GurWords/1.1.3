package Service;

import InterfaceDAO.UserDAO;
import InterfaceService.InterfaceUsersService;
import UserDAO.*;
import Model.User;

import java.util.List;


public class UsersService implements InterfaceUsersService {

    private static UsersService instance = null;

    private UsersService() {
    }

    public static UsersService getInstance() {
        if (instance == null) {
            instance = new UsersService();
        }
        return instance;
    }

    public void updateUser(User newUser) {
        UserDAO userDAO = UserHibernateDAO.getInstance();
        userDAO.updateUser(newUser);
    }

    public List<User> selectAllUsers() {
        UserDAO userDAO = UserJdbcDAO.getInstance();
        return userDAO.selectAllUsers();
    }

    public void insertUser(User user) {
        UserDAO userDAO = UserHibernateDAO.getInstance();
        userDAO.insertUser(user);
    }

    public void deleteUser(User user) {
        UserDAO userDAO = UserHibernateDAO.getInstance();
        userDAO.deleteUser(user);
    }
    public long getIdByName(String name){
        UserDAO userDAO = UserHibernateDAO.getInstance();
        return userDAO.getIdByName(name);
    }

}

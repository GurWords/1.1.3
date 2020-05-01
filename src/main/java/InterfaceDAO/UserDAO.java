package InterfaceDAO;

import Model.User;

import java.util.List;

public interface UserDAO {
    void deleteUser(User user);
    List<User> selectAllUsers();
    void updateUser(User newUser);
    void insertUser(User user);
    long getIdByName(String name);
}

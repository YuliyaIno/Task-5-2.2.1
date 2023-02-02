package hiber.service;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    User getUserByCar(String model, int series);

}
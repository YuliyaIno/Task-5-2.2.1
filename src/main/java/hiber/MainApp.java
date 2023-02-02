package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Mazda",1);
      Car car2 = new Car("Audi",2);
      Car car3 = new Car("VAZ",33);
      Car car4 = new Car("Tayota",4);

      userService.add(new User("Yuliya", "Ino", "yuliyaino@mail.ru", car1));
      userService.add(new User("Ivan", "Ivanov", "ivanivanov@mail.ru", car2));
      userService.add(new User("Petr", "Petrov", "petrpetrov@mail.ru", car3));
      userService.add(new User("Anton", "Antonov", "antonantonov@mail.ru", car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      User user = userService.getUserByCar(car2.getModel(), car2.getSeries());
      System.out.println("Car model = "+car2.getModel() + "; series = " + car2.getSeries());
      System.out.println("Id = "+user.getId());
      System.out.println("First Name = "+user.getFirstName());
      System.out.println("Last Name = "+user.getLastName());
      System.out.println("Email = "+user.getEmail());
      System.out.println();

      context.close();
   }
}
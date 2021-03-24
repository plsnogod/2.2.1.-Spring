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

      Car car1 = new Car(2,"Audi");
      Car car3 = new Car(3,"Fiat");
      Car car2 = new Car(4,"Opel");
     userService.addCar(car1);
     userService.addCar(car3);
     userService.addCar(car2);

//   userService.add(new User("Vasya", "Ivanov", "ivanov@mail.ru",car1));
//   userService.add(new User("Petya", "Petrov", "petrov@mail.ru",car2));
//   userService.add(new User("Sidor", "Sidirov", "Sidorov@mail.ru",car3));
       System.out.println(userService.getUserByCar(1,"Opel"));
//      userService.add(new User("Jaccki", "Chan", "Best@mail.ru"));
 //    userService.add(new User("boba","biba","BB@mail.ru",new Car(1,"Porsche")));
//     userService.add(new User("Vasya","Ivanov","Ivanov@mail.ru",new Car(2,"Lada")));
//     userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      context.close();
   }
}

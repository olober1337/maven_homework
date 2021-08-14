package homework1;

import homework1.entities.Admin;
import homework1.entities.Human;
import homework1.entities.User;
import homework1.service.AdminService;
import homework1.service.UserService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Human user = new User();
        user.setName("Guy");
        user.setLastName("Ritchie");
        user.setAge(52);
        user.setEmailAddress("guy.ritchie@gmail.com");
        user.setPassword("TheGentlemen");

        Human admin = new Admin();
        admin.setName("Martin");
        admin.setLastName("Scorsese");
        admin.setAge(78);
        admin.setEmailAddress("martin.scorsese@gmail.com");
        admin.setPassword("GoodFellas");

        UserService userService = new UserService();
        AdminService adminService = new AdminService();

        userService.writeHumanInfo(user);
        adminService.writeHumanInfo(user);
        adminService.writeHumanInfo(admin);

        System.out.println(userService.humanChecker(user));
        System.out.println(adminService.humanChecker(admin));

    }
}

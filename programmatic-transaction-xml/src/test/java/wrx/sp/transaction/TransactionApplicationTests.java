package wrx.sp.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wrx.sp.transaction.service.UserService;

@SpringBootTest
class TransactionApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        System.out.print("hello test");

        userService.transfer();

    }

}

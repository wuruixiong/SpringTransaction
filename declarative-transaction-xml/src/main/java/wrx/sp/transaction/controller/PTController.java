package wrx.sp.transaction.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wrx.sp.transaction.bean.UserBean;
import wrx.sp.transaction.service.UserService;

@RestController
public class PTController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public String helloWorld () {
        return "helloWorld";
    }

    @RequestMapping("/transfer/transaction")
    public String transferTransaction(){
        userService.transferTransaction();
        return "success";
    }


}

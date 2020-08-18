package wrx.sp.transaction.service;

import wrx.sp.transaction.bean.UserBean;

public interface UserService {
    UserBean selectUserByName(String name);
    void update(String username, Integer balance);
    void transfer();
    void transferTransaction();
}

package wrx.sp.transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import wrx.sp.transaction.bean.UserBean;
import wrx.sp.transaction.mapper.UserMapper;
import wrx.sp.transaction.service.UserService;


@Service("TUserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void transferTransaction() {
        // 一个操作可以看做是一个事务，执行到一半报错，不会影响已经提交的数据
        userMapper.updateBalance("Tom", 900);

        int x = 10;
        if (x == 10) {
            throw new RuntimeException("出错");
        }

        userMapper.updateBalance("Jerry", 1100);
    }
}

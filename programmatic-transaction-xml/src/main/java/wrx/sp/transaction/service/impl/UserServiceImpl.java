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

    // 获取到已经applicationContext.xml里面已经生成好的模板
    @Autowired
    TransactionTemplate transactionTemplate;

    @Override
    public UserBean selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public void update(String username, Integer balance) {
        userMapper.updateBalance(username, balance);
    }


    @Override
    public void transferTransaction() {

        transactionTemplate.execute(
                // 整个可以看做是一个事务，两条指令
                // 如果中间报错，第一条指令会回滚
                transactionStatus -> {
                userMapper.updateBalance("Tom", 900);

                int x = 10;
                if (x == 10) {
                    throw new RuntimeException("出错");
                }

                userMapper.updateBalance("Jerry", 1100);

                return null;
            }
        );

    }

    @Override
    public void transfer() {
        // 一个操作可以看做是一个事务，执行到一半报错，不会影响已经提交的数据
        userMapper.updateBalance("Tom", 900);

        int x = 10;
        if (x == 10) {
            throw new RuntimeException("出错");
        }

        userMapper.updateBalance("Jerry", 1100);
    }
}

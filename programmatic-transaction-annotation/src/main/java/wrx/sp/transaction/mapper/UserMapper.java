package wrx.sp.transaction.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import wrx.sp.transaction.bean.UserBean;

@Mapper
public interface UserMapper {


    @Select("select * from transaction_user where username = #{username}")
    UserBean selectUserByName(String username);

    @Update("update transaction_user set balance = #{balance} where name = #{username}")
    void updateBalance(String username, Integer balance);

}


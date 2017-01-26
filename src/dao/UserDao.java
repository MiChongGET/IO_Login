package dao;

import user.Users;

/**
 * Created by Administrator on 2017/1/26.
 */
public interface UserDao {

    /**登录功能
     * @param username
     * @param passwd
     * @return  返回登录是否成功
     */
    public abstract boolean isLogin(String username,String passwd);

    /**
     * 注册功能
     * @param user
     */
    public abstract void regist(Users user);

}

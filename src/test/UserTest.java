package test;


import dao.UserDao;
import dao.impl.UserDaoimpl;
import user.Users;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/12.
 * 用户测试类
 */
public class UserTest {

    public static void main(String[] args) {

        while (true) {

            //欢迎界面，给出选择项
            System.out.println("-------Welcome-----");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.退出");
            System.out.println("请输入你的选择:");

            //键盘录入
            Scanner sc = new Scanner(System.in);
            //为了后面的录入方便，使用字符串
            String choiceString = sc.nextLine();

            //多个地方要使用
            UserDao ud = new UserDaoimpl();
            switch (choiceString) {
                case "1":
                    System.out.println("------登录界面-----");
                    System.out.println("请输入用户名：");
                    String Username = sc.nextLine();

                    System.out.println("请输入密码：");
                    String Password = sc.nextLine();

                    //调用登录功能
                    boolean flag = ud.isLogin(Username, Password);
                    if (flag) {
                        System.out.println("登录成功！！");
                       // break;结束的是switch
                        System.out.println("play game?Y/N");
                        if (sc.nextLine().equalsIgnoreCase("y")){


                        }

                        System.exit(0);
                    } else {
                        System.out.println("登录失败！！");
                    }

                    break;

                case "2":
                    System.out.println("------注册界面-----");
                    System.out.println("请输入用户名：");
                    String newUsername = sc.nextLine();

                    System.out.println("请输入密码：");
                    String newPassword = sc.nextLine();

                    //把用户名密码封装到一个对象中去
                    Users user = new Users();
                    user.setName(newUsername);
                    user.setPasswd(newPassword);

                    //调用注册功能
                    //多态

                    ud.regist(user);

                    break;
                case "3":
                    System.out.println("欢迎使用");
                    System.exit(0);
                    break;
            }
        }
    }
}
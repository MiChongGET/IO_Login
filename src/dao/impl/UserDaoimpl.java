package dao.impl;

import dao.UserDao;
import user.Users;

import java.io.*;

/**
 * Created by Administrator on 2017/1/26.
 * 具体实现类
 */
public class UserDaoimpl implements UserDao {

    //静态代码块，程序运行即执行
    private static File file = new File("user.txt");

    static {
        try {
            file.createNewFile();
            System.out.println("用户数据文件加载成功！！！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("用户数据文件创建失败！！！");
        }
    }


    @Override
    public boolean isLogin(String username, String password) {
        boolean flag = false;

        BufferedReader br =null;
        try {
            br =  new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine())!=null){
                String[] datas = line.split("=");
                if (datas[0].equals(username) && datas[1].equals(password)){
                    flag = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!!!");
        }catch (IOException e){
            System.out.println("Login faild!!!");
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("登录资源释放失败！！！");
                }
            }
        }
        return flag;
    }

    @Override
    public void regist(Users user) {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {

            boolean flag = false;
            //实现用户名判断功能
            if (flag==false){
                br =  new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = br.readLine())!=null){
                    String[] s = line.split("=");
                    if (s[0].equals(user.getName())){
                        System.out.println("用户名已经存在！！！");
                        flag = true;
                        break;
                        }
                    }
            }
            //使用true是为了数据不会覆盖
            if (flag==false){bw = new BufferedWriter(new FileWriter(file,true));
            bw.write(user.getName()+"="+user.getPasswd());
            bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("注册释放资源失败！！！");
                }
            }
        }
    }
}

package com.vinayprabhakarx.io.deserialization;

import com.vinayprabhakarx.pojo.LoginInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoginDeserialize {
    static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "src/com/vinayprabhakarx/io/file/login-info.ser";

        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        LoginInfo loginInfo = (LoginInfo) objectInputStream.readObject();
        System.out.println(loginInfo);


    }
}


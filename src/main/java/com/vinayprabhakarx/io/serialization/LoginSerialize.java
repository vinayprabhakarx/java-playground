package com.vinayprabhakarx.io.serialization;
import com.vinayprabhakarx.pojo.LoginInfo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class LoginSerialize {
    static void main(String[] args) throws IOException {
        LoginInfo loginSerialize = new LoginInfo(101, "vinayprabhakarx", "Vinay@123");
        System.out.println(loginSerialize);

        String filePath = "src/main/resources/com/vinayprabhakarx/io/file/login-info.ser";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(loginSerialize);
        fileOutputStream.close();
        objectOutputStream.close();
    }

}

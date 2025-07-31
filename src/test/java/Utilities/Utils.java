package Utilities;

import BaseClass.BaseClass;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Utils  {

    static String configPropertyPath =System.getProperty("user.dir")+ File.separator +"src"+File.separator+"test"+File.separator+"resources"+File.separator+"configs"+File.separator+"config.properties";

    public String getConfigBrowser() throws Exception{
        FileReader fileReader = new FileReader(configPropertyPath);
        Properties pro = new Properties();
        pro.load(fileReader);
        return pro.getProperty("Browser");
    }

    public Properties configProperty() throws Exception{
        FileReader fileReader = new FileReader(configPropertyPath);
        Properties pro = new Properties();
        pro.load(fileReader);
        return pro;
    }

    public String getConfigURLEcom() throws Exception{
        FileReader fileReader = new FileReader(configPropertyPath);
        Properties pro = new Properties();
        pro.load(fileReader);
        return pro.getProperty("URLEcom");
    }

    public String getConfigURLTestPage() throws Exception{
        FileReader fileReader = new FileReader(configPropertyPath);
        Properties pro = new Properties();
        pro.load(fileReader);
        return pro.getProperty("URLTestPages");
    }

    public String getConfigURLPages() throws Exception{
        FileReader fileReader = new FileReader(configPropertyPath);
        Properties pro = new Properties();
        pro.load(fileReader);
        return pro.getProperty("URLPages");
    }

    public static String getConfigUserName() throws Exception{
        FileReader fileReader = new FileReader(configPropertyPath);
        Properties pro = new Properties();
        pro.load(fileReader);
        return pro.getProperty("UserName");
    }

    public static String getConfigPassword() throws Exception{
        FileReader fileReader = new FileReader(configPropertyPath);
        Properties pro = new Properties();
        pro.load(fileReader);
        return pro.getProperty("password");
    }

}

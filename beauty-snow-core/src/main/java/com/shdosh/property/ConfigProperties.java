package com.shdosh.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class ConfigProperties extends Properties {

    public ConfigProperties(String fileName) throws IOException{
        System.out.println("~~~~~~初始化开始~~~~~~");
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        this.createProperty(new File(url.getFile()));
        System.out.println("~~~~~~初始化结束~~~~~~");
    }
    public void createProperty(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        this.load(inputStream);
    }
}

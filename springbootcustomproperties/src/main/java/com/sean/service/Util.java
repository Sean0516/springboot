package com.sean.service;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Sean on 2018/8/1
 *
 * @author Sean
 */
public class Util {
    public void test() {
        URL resource = Util.class.getClassLoader().getResource("application.yml");
        System.out.println(resource);
    }

    public static void main(String[] args) throws IOException {
        Yaml yaml=new Yaml();
        URL resource = Util.class.getClassLoader().getResource("application.yml");
        String path = resource.getPath();
        Map map= (Map) yaml.load(new FileInputStream(path));
        Map map1= (Map) map.get("spring");
        Map  map2 = (Map) map1.get("datasource");
        map2.put("url","hello222");
        yaml.dump(map,new FileWriter(path));

/*        URL resource = Util.class.getClassLoader().getResource("config/user.properties");
        String path = resource.getPath();
        Properties properties = new Properties();
        properties.load(new FileReader(path));
        System.out.println(properties.getProperty("user.name"));
        properties.put("user.name", "hellssso");
        properties.store(new FileOutputStream(path), "");*/
    }


}

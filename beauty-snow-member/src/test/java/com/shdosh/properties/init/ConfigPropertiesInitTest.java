package com.shdosh.properties.init;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shdosh.property.ConfigProperties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-init-properties.xml"})
public class ConfigPropertiesInitTest {

    @Autowired
    ConfigProperties configProperties;
    @Test
    public void testPropertiesTest() {
        System.out.println(configProperties);
    }
}

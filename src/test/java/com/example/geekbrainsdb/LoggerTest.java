package com.example.geekbrainsdb;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

    Logger logger = LoggerFactory.getLogger(LoggerTest.class);


    @Test
    public void testLogging(){
        String s = null;
        try{
            s.length();
        } catch (Exception e) {
            logger.error("Error during saving user", e);
        }
    }


}

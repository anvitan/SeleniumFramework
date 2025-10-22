package com.practice.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {
    private ConfigReader(){}

    public static FrameWorkConfig getConfig(){
        return ConfigFactory.create(FrameWorkConfig.class);
    }

}

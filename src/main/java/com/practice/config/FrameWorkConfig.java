package com.practice.config;
import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/java/com/practice/resources/config.properties")
public interface FrameWorkConfig extends Config {

    long timeout();

    String url();

    String browser();
}

package com.chuanze.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix="com.chuanze.admin")
@PropertySource(value="classpath:admin.properties")
public class Admin {
    private String name;
    private int age;
    private String address;
}

package com.chuanze.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnvModel {
    private String dir;
    private String home;
    private String javaHome;
    private String serverPort;

    public EnvModel(String dir, String home, String javaHome, String serverPort) {
        this.dir = dir;
        this.home = home;
        this.javaHome = javaHome;
        this.serverPort = serverPort;
    }
}

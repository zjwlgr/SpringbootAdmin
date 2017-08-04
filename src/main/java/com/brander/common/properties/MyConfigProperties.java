package com.brander.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 有时候有这样子的情景，我们想把配置文件的信息，读取并自动封装成实体类，
 * 这样子，我们在代码里面使用就轻松方便多了，这时候，我们就可以使用 @ConfigurationProperties，
 * 它可以把同类的配置信息自动封装成实体类
 * configuration annotation processor not found in classpath
 */
@Component
@ConfigurationProperties(prefix = "myconfig")
public class MyConfigProperties {

    private String version;

    private String weburl;

    private String webname;

    private String adminname;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public String getWebname() {
        return webname;
    }

    public void setWebname(String webname) {
        this.webname = webname;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }



}

package com.study.cloud.order.config;

import com.google.common.base.MoreObjects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * 服务配置
 *
 * @author KelvinZ
 * @date 2018-12-07 14:36
 */
@Configuration
@RefreshScope
public class ServiceConfiguration {
    @Value("${env}")
    private String env;

    @Value("${version}")
    private String version;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("env", env)
                .add("version", version)
                .toString();
    }
}

package com.javamokey.adminxx.modules.sys.redis;


import com.javamokey.adminxx.common.util.RedisKeys;
import com.javamokey.adminxx.common.util.RedisUtils;
import com.javamokey.adminxx.modules.sys.entity.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 系统配置Redis
 */
@Component
public class SysConfigRedis {
    @Autowired
    private RedisUtils redisUtils;

    public void saveOrUpdate(SysConfig config) {
        if (config == null) {
            return;
        }
        String key = RedisKeys.getSysConfigKey(config.getConfigKey());
        redisUtils.set(key, config);
    }

    public void delete(String configKey) {
        String key = RedisKeys.getSysConfigKey(configKey);
        redisUtils.delete(key);
    }

    public SysConfig get(String configKey) {
        String key = RedisKeys.getSysConfigKey(configKey);
        return redisUtils.get(key, SysConfig.class);
    }
}

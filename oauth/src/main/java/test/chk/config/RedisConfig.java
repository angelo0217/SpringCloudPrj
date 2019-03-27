//package com.chk.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// * 拆分Redis存儲位置
// * Created on 2018/12/26
// *
// * @author dean
// * @email loveangelo0217@gmail.com
// * @since 1.0
// */
//@Configuration
//public class RedisConfig {
//
//    @Value("${redis.host}")
//    protected String redisHostName;
//
//    @Value("${redis.port}")
//    protected int redisPort;
//
//    @Value("${redis.password}")
//    protected String password;
//
//    @Value("${redis.jedis.pool.min-idle}")
//    protected int minIdle;
//
//    @Value("${redis.jedis.pool.max-idle}")
//    protected int maxIdle;
//
//    @Value("${redis.jedis.pool.test-on-borrow}")
//    protected boolean testOnBorrow;
//
//    @Value("${redis.jedis.pool.test-on-return}")
//    protected boolean testOnReturn;
//
//    @Value("${redis.oauth.database}")
//    protected int oauthDatabase;
//
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//
//    @Bean("tokenRedis")
//    @Primary
//    JedisConnectionFactory tokenRedis() {
//        JedisConnectionFactory factory = new JedisConnectionFactory(jedisPoolConfig());
//        factory.setHostName(redisHostName);
//        factory.setPort(redisPort);
//        factory.setDatabase(oauthDatabase);
//        factory.setUsePool(true);
//        return factory;
//    }
//
//    public JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//
//        //控制一個pool可分配多少個jedis實例,用來替換上面的redis.maxActive,如果是jedis 2.4以後用該屬
//        //poolConfig.setMaxTotal(maxTotal);
//        //連接池中的最小空閒連接
//        poolConfig.setMinIdle(minIdle);
//        //最大空閒數
//        poolConfig.setMaxIdle(maxIdle);
//        //連接的最小閒置時間 默認1800000毫秒(30分鐘)
//        poolConfig.setMaxWaitMillis(300000);
//        //每次釋放連接的最大數目,預設3
//        poolConfig.setNumTestsPerEvictionRun(10);
//        //逐出掃描的時間間隔(毫秒) 如果為負數,則不運行逐出執行緒, 默認-1
//        poolConfig.setTimeBetweenEvictionRunsMillis(-1);
//        //是否在從池中取出連接前進行檢驗,如果檢驗失敗,則從池中去除連接並嘗試取出另一個
//        poolConfig.setTestOnBorrow(testOnBorrow);
//        poolConfig.setTestOnReturn(testOnReturn);
//        return poolConfig;
//    }
//}

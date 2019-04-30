package me.bs.java.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
	public class RedisConfig {
	    
	    @Bean
	    public RedisConnectionFactory redisConnectionFactory() {
	        final JedisPoolConfig poolConfig = new JedisPoolConfig();
	        poolConfig.setMaxTotal(5);
	        poolConfig.setTestOnBorrow(true);
	        poolConfig.setTestOnReturn(true);

	        final JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
	        connectionFactory.setUsePool(true);
	        connectionFactory.setHostName("192.168.99.100");
	        connectionFactory.setPort(32768);
	        return connectionFactory;
	    }
	    
	    @Bean
	    public RedisTemplate<?, ?> redisTemplate() {
	        final RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
	        redisTemplate.setConnectionFactory(redisConnectionFactory());
	        redisTemplate.setEnableTransactionSupport(true);
	        redisTemplate.setKeySerializer(new StringRedisSerializer());
	        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
	        return redisTemplate;
	    }

//	    @Bean
//	    public RedisTemplate<String, String> stringRedisTemplate() {
//	        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(redisConnectionFactory());
//	        stringRedisTemplate.setEnableTransactionSupport(true);
//	        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
//	        stringRedisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//	        stringRedisTemplate.afterPropertiesSet();
//	        return stringRedisTemplate;
//	    }

	}
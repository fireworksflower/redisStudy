package com.hh.redisdemo;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by IntelliJ IDEA.
 *
 * @author lijing
 * @date 2019/8/28 11:21
 **/
public class GenericObjectPoolConfigDemo {
  public static void main(String[] args) {

      GenericObjectPoolConfig  poolConfig = new GenericObjectPoolConfig();
      JedisPool jedisPool = new JedisPool(poolConfig,"119.23.108.42", 6379);
      Jedis jedis = null;
      try{
          //1.从连接池获取jedis对象
            jedis = jedisPool.getResource();
           // jedis.set("name","ww" );
            String hello = jedis.get("age");
            System.out.println(hello);
      }catch (Exception e){
            e.printStackTrace();
      }finally{
          if(null !=jedis){
              //此处使用jedis连接池JedisPool,close操作不是关闭连接，代表归还连接池
            jedis.close();
          }
    }
  }
}

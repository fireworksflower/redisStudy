package com.hh.redisdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 *
 * @author lijing
 * @date 2019/9/4 14:01
 **/
public class SentinelDemo {

  public static void main(String[] args) {
    String masterName = "mymaster";
      Set<String> sentinels = new HashSet<String>();
      sentinels.add("119.23.108.42:26379");
      sentinels.add("119.23.108.42:26380");
      sentinels.add("119.23.108.42:26381");
      JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(masterName,sentinels);

      Jedis jedis = null;
      try {
          jedis = jedisSentinelPool.getResource();
          System.out.println(jedis);
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
      }


     /* jedis.set("hello","world" );
      String hello = jedis.get("hello");
    System.out.println(hello);*/
  }
}

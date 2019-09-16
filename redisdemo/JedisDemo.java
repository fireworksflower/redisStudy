package com.hh.redisdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 *
 * @author lijing
 * @date 2019/8/28 9:15
 **/
public class JedisDemo {
  public static void main(String[] args) {
      JedisDemo jedisDemo = new JedisDemo();
      jedisDemo.jedisMethod();
  }

  public void jedisMethod() {

    Jedis jedis = null;
    try {
      jedis = new Jedis("119.23.108.42", 6379);
      //string
      String set = jedis.set("hello", "world");//ok
      String hello = jedis.get("hello");// world
      Long counter = jedis.incr("counter");//1
      //hash
      Long hset = jedis.hset("myhash", "f1", "v1");
      Map<String, String> myhash = jedis.hgetAll("myhash");//{f1=v1}
      //list
      jedis.rpush("mylist","1");
      jedis.rpush("mylist","2");
      List<String> mylist = jedis.lrange("mylist", 0, -1);//[1, 2]
      //set
      jedis.sadd("myset","a");
      jedis.sadd("myset","b");
      Set<String> myset = jedis.smembers("myset");//[b, a]

      //zset
      jedis.zadd("myzset",99 ,"tom" );
      jedis.zadd("myzset",66 ,"peter" );
      Set<Tuple> myzadd = jedis.zrangeWithScores("myzset", 0, -1);//[[peter,66.0], [tom,99.0]]
      System.out.println(myzadd);

    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      if(null !=jedis){
        jedis.close();
      }
    }
}
}

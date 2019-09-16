package com.hh.redisdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author lijing
 * @date 2019/8/28 11:28
 **/
public class PipelineDemo {
  public static void main(String[] args) {
        PipelineDemo pipelineDemo = new PipelineDemo();
      long l = System.currentTimeMillis();
        pipelineDemo.model();
      long l1 = System.currentTimeMillis();

      System.out.println(l1-l);
}
  public void model(){
      Jedis jedis = new Jedis("119.23.108.42", 6379);


      for (int i = 0; i < 100; i++) {
        //1.生成pipeline对象
        Pipeline pipeline = jedis.pipelined();
      for (int j = i; j < (i+1)*100 ;j++) {
        pipeline.hset("hashkey:"+j,"field"+j,"value"+j);
      }
        List<Object> objects = pipeline.syncAndReturnAll();
      //System.out.println(objects);
    }

  }
}

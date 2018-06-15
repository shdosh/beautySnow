package com.shdosh.kafka.log.producer;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shdosh.kafka.producer.template.KafkaProducerTemplate;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-kafka-producer.xml"})
public class KafkaProducerTest {
    @Autowired
    private KafkaProducerTemplate kafkaProducer;
    @Test
    public void testKafkaProducer() throws InterruptedException, ExecutionException {
        //KafkaProducerServer kafkaProducer = new KafkaProducerServer();
        String topic = "logTopic";
        String value = "logTest1";
        String ifPartition = "0";
        Integer partitionNum = 1;
        String role = "logRole";//用来生成key
        Map<String,Object> res = kafkaProducer.sendMesForTemplate(topic, value, ifPartition, partitionNum, role);
        System.out.println("测试结果如下：==============="+res);
        String message = (String)res.get("message");
        String code = (String)res.get("code");
        
        System.out.println("code:"+code);
        System.out.println("message:"+message);
    }
}

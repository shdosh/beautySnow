package com.shdosh.kafka.producer.template;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.alibaba.fastjson.JSON;
import com.shdosh.log.entity.KafkaMesConstant;

/**
 * kafkaProducer模板
 *      使用此模板发送消息
 * @author shdosh
 */
@Component
public class KafkaProducerTemplate {
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    /**
     * kafka发送消息模板
     * @param topic
     * @param value
     * @param ifPartition
     * @param partitionNum
     * @param role
     * @return
     * @throws ExecutionException 
     * @throws InterruptedException 
     */
    public Map<String,Object> sendMesForTemplate(String topic, Object value, String ifPartition, Integer partitionNum, String role) throws InterruptedException, ExecutionException{
        String key = role + "-" + value.hashCode();
        String valueString = JSON.toJSONString(value);
        if (ifPartition.equals("0")) {
            //表示使用分区
            int partitionIndex = getPartitionIndex(key, partitionNum);
            ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, partitionIndex, key, valueString);
            System.out.println("发送结果~~~~"+result.get().getProducerRecord());
            Map<String,Object> res = checkProRecord(result);
            return res;
        } else {
            ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, key, valueString);
            Map<String,Object> res = checkProRecord(result);
            return res;
        }
    }
    
    /**
     * 根据key值获取分区索引
     * @param key
     * @param partitionNum
     * @return
     */
    private int getPartitionIndex(String key, int partitionNum){
        if (key == null) {
            Random random = new Random();
            return random.nextInt(partitionNum);
        } else {
            int result = Math.abs(key.hashCode()) % partitionNum;
            return result;
        }
    }
    
    /**
     * 检查发送返回结果record
     * @param res
     * @return
     */
    private Map<String,Object> checkProRecord(ListenableFuture<SendResult<String, String>> res){
        Map<String,Object> m = new HashMap<String,Object>();
        if (res != null) {
            try {
                SendResult r = res.get();//检查result结果
                /*检查recordMetadata的offset数据，不检查producerRecord*/
                Long offsetIndex = r.getRecordMetadata().offset();
                if (offsetIndex != null && offsetIndex>=0) {
                    m.put("code", KafkaMesConstant.SUCCESS_CODE);
                    m.put("message", KafkaMesConstant.SUCCESS_MES);
                } else {
                    m.put("code", KafkaMesConstant.KAFKA_NO_OFFSET_CODE);
                    m.put("message", KafkaMesConstant.KAFKA_NO_OFFSET_MES);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                m.put("code", KafkaMesConstant.KAFKA_SEND_ERROR_CODE);
                m.put("message", KafkaMesConstant.KAFKA_SEND_ERROR_MES);
            } catch (ExecutionException e) {
                e.printStackTrace();
                m.put("code", KafkaMesConstant.KAFKA_SEND_ERROR_CODE);
                m.put("message", KafkaMesConstant.KAFKA_SEND_ERROR_MES);
            }
        } else {
            m.put("code", KafkaMesConstant.KAFKA_NO_RESULT_CODE);
            m.put("message", KafkaMesConstant.KAFKA_NO_RESULT_MES);
        }
        return m;
    }
    
    public static void main(String[] args){
        /*Properties properties = new Properties();*/
    }
}

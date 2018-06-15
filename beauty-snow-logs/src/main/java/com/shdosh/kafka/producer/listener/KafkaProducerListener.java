package com.shdosh.kafka.producer.listener;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;

/**
 * kafkaProducer监听器，在producer配置文件中开启
 * @author shdosh
 */
public class KafkaProducerListener implements ProducerListener {

    private final Logger LOG = LoggerFactory.getLogger(KafkaProducerListener.class);
    /**
     * 方法返回值代表是否启动kafkaProducer监听器
     */
    @Override
    public boolean isInterestedInSuccess() {
        LOG.info("~~~~~~kafkaProducer监听器启动~~~~~~");
        return true;
    }

    /**
     * 发送消息错误后调用
     * @param topic
     * @param partition
     * @param key
     * @param value
     * @param exception
     */
    @Override
    public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
        LOG.info("======kafka发送数据错误(日志开始)======");
        LOG.info("------topic:"+topic);
        LOG.info("------value:"+value);
        LOG.info("------key:"+key);
        LOG.info("------Exception:"+exception);
        LOG.info("------partition:"+partition);
        LOG.info("~~~~~~kafka发送数据错误(日志结束)~~~~~~");
        
    }

    /**
     * 发送消息成功后调用
     * @param topic
     * @param partition
     * @param key
     * @param value
     * @param recordMetadata
     */
    @Override
    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
        LOG.info("======kafka发送数据成功(日志开始)======");
        LOG.info("------topic:"+topic);
        LOG.info("------value:"+value);
        LOG.info("------key:"+key);
        LOG.info("------partition:"+partition);
        LOG.info("------RecordMetadata:"+recordMetadata);
        LOG.info("~~~~~~kafka发送数据成功(日志结束)~~~~~~");
    }

}

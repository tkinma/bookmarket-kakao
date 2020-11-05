package bookmarket;

import bookmarket.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    KakaoAlarmRepository kakaoAlarmRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRegistered_CreateKakaoId(@Payload Registered registered){

        if(registered.isMe()){
            System.out.println("##### listener CreateKakaoId : " + registered.toJson());

        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryStatusChanged_SendKakaoMessage(@Payload DeliveryStatusChanged deliveryStatusChanged){

        if(deliveryStatusChanged.isMe()){
            System.out.println("##### listener SendKakaoMessage : " + deliveryStatusChanged.toJson());

            KakaoAlarm kakaoAlarm = new KakaoAlarm();
            kakaoAlarm.setDeliveryId(deliveryStatusChanged.getId());
            kakaoAlarm.setDeliveryStatus(deliveryStatusChanged.getDeliveryStatus());
            kakaoAlarm.setKakaoMessage("Book Delivery Status Changed : " + deliveryStatusChanged.getDeliveryStatus());

            kakaoAlarmRepository.save(kakaoAlarm);
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOderCanceled_SendKakaoMessage(@Payload OrderCanceled orderCanceled){

        if(orderCanceled.isMe()){
            System.out.println("##### listener SendKakaoMessage : " + orderCanceled.toJson());

            KakaoAlarm kakaoAlarm = new KakaoAlarm();
            kakaoAlarm.setDeliveryId(orderCanceled.getId());
            kakaoAlarm.setDeliveryStatus("OderCanceled");
            kakaoAlarm.setKakaoMessage("Book Order Canceled");

            kakaoAlarmRepository.save(kakaoAlarm);
        }
    }

}

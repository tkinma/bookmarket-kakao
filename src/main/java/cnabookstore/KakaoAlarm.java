package cnabookstore;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="KakaoAlarm_table")
public class KakaoAlarm {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long deliveryId;
    private String kakaoMessage;
    private String deliveryStatus;

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getKakaoMessage() {
        return kakaoMessage;
    }

    public void setKakaoMessage(String kakaoMessage) {
        this.kakaoMessage = kakaoMessage;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @PrePersist
    public void onPrePersist(){
        MessageSended messageSended = new MessageSended();
        BeanUtils.copyProperties(this, messageSended);
        messageSended.publishAfterCommit();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

package cnabookstore;

public class MessageSended extends AbstractEvent {

    private Long id;
    private Long deliveryId;

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

    private String kakaoMessage;
    private String deliveryStatus;

    public MessageSended(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

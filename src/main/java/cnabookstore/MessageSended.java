package cnabookstore;

public class MessageSended extends AbstractEvent {

    private Long id;

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

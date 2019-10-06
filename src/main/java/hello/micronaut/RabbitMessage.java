package hello.micronaut;

public class RabbitMessage {

    private String name;

    public RabbitMessage(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

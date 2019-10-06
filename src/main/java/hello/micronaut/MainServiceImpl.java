package hello.micronaut;

import hello.models.Product;
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.context.annotation.Value;
import io.micronaut.scheduling.annotation.Scheduled;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class MainServiceImpl implements MainService {

    private int count;

    @PersistenceContext
    private EntityManager entityManager;

    private RabbitChannel rabbitChannel;

    @Value("${micronaut.main.name}")
    private String name;

    public MainServiceImpl(@CurrentSession EntityManager entityManager, RabbitChannel rabbitChannel){
        count = 0;
        this.entityManager = entityManager;
        this.rabbitChannel = rabbitChannel;
        System.out.println("Started main service");
    }

    @MethodLog
    public void print(){
        System.out.println("Main Service "+name);
    }

    @MethodLog
    public int trackCount(){
        count++;
        return count;
    }

    @MethodLog
    public void sendMsg(String any){
        System.out.println("Main Service sending rabbit msg");
        rabbitChannel.sendMsg(new RabbitMessage("test"));
    }

    @Transactional
    @MethodLog
    public int readDB(){
        int pSize = entityManager.createQuery("Select p from Product p",Product.class).getResultList().size();
        System.out.println("Main Service db read p count "+pSize);
        return pSize;
    }

    @Scheduled(fixedRate = "5m")
    void everyFiveMinutes() {
        System.out.println("Executing everyFiveMinutes()");
    }
}

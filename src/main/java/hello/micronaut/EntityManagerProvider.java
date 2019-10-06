package hello.micronaut;

import io.micronaut.configuration.hibernate.jpa.EntityManagerFactoryBean;

import javax.inject.Singleton;

@Singleton
public class EntityManagerProvider {

    private EntityManagerFactoryBean entityManagerFactoryBean;

    public EntityManagerProvider(EntityManagerFactoryBean entityManagerFactoryBean){
        this.entityManagerFactoryBean = entityManagerFactoryBean;
        System.out.println("EntityManagerProvider started");
        System.out.println(entityManagerFactoryBean.toString());
    }

    public EntityManagerFactoryBean getEM(){
        return entityManagerFactoryBean;
    }
}

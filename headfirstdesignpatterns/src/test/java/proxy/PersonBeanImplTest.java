package proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

class PersonBeanImplTest {
    Hashtable datingDB = new Hashtable();


    @BeforeEach
    void setUp() {
        initializeDatabase();
    }

    @Test
    void name() {
        PersonBean joe = getPersonFromDatabase("Joe Javabean");
        PersonBean onwerProxy = getOwnerProxy(joe);
        System.out.println("onwerProxy = " + onwerProxy.getName());
        onwerProxy.setInterests("bowling, Go");

        try {
            onwerProxy.getGender();
        } catch (Exception e) {
            System.out.println("e = " + "");
        }
        System.out.println("onwerProxy.getHotOrNotRating() = " + onwerProxy.getHotOrNotRating());
    }

    PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    PersonBean getPersonFromDatabase(String name) {
        return (PersonBean)datingDB.get(name);
    }

    void initializeDatabase() {
        PersonBean joe = new PersonBeanImpl();
        joe.setName("Joe Javabean");
        joe.setInterests("cars, computers, music");
        joe.setHotOrNotRating(7);
        datingDB.put(joe.getName(), joe);

        PersonBean kelly = new PersonBeanImpl();
        kelly.setName("Kelly Klosure");
        kelly.setInterests("ebay, movies, music");
        kelly.setHotOrNotRating(6);
        datingDB.put(kelly.getName(), kelly);
    }

}
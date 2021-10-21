package singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    void 싱글톤패턴_두개_이상_생성시_동일한_객체인지_테스트() {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        assertEquals(instance,instance2);
    }

}
package edu.umb.cs680.hw03;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    public void toCheckWhetherTheInstanceIsSame(){
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = SingletonClass.getInstance();
        Assertions.assertNotNull(instance1);
        Assertions.assertNotNull(instance2);
        Assertions.assertSame(instance1, instance2);
    }

}

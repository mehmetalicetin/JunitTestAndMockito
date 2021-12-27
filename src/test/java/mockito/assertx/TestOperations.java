package mockito.assertx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import javax.crypto.IllegalBlockSizeException;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-21
 */
public class TestOperations {

    /*
    * @Test
    * @BeforeEach
    * @AfterEach
    * @BeforeAll
    * @AfterAll
    * @DisplayName
    * @Tag
    * */


    @Test
    @DisplayName("fail method execution")
    @Tag("prod")
    public void testFailed(){
        //Assertions.fail();
       //Assertions.fail("Operation has been failed");
        // Assertions.fail(new IllegalArgumentException("Operation failed"));
       //Assertions.fail("Operation has been failed", new IllegalBlockSizeException("Block size Exception"));
       Assertions.fail(()->"Operation has been failed by Message Supplier");
    }

    @Test
    @DisplayName("assertTrue method execution")
    @Tag("preProd")
    public void testAssertTrue(){
        // Assertions.assertTrue(true);
        // Assertions.assertTrue(()->false);
        // Assertions.assertTrue(false,"Failed Operation");
        // Assertions.assertTrue(()->false,"Failed Operation");
        Assertions.assertTrue(false,()->"Failed Operation");
        Assertions.assertTrue(()->false,()->"Failed Operation");
    }


    @Test
    @DisplayName("assertEquals method execution")
    @Tag("local")
    public void testAssertEquals(){
        Assertions.assertEquals(0.4,0.4,0.001);
    }

}

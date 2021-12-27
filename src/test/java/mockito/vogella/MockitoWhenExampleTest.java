package mockito.vogella;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.quality.Strictness;

import java.util.Iterator;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-24
 */

@ExtendWith(MockitoExtension.class)
public class MockitoWhenExampleTest {

    // activate the strict subs rule
    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Mock
    Iterator<String> i;

    //demonstrates the return of multiple values
    @Test
    void testMoreThanOneREturnValue(){
        when(i.next()).thenReturn("Mockito").thenReturn("Rocks");
        String result = i.next()+" "+i.next();

        Assertions.assertEquals("Mockito Rocks", result);
    }

    // this test demonstrates how to return values based on the input
    // and that @Mock can also be used for a method parameter
    @Test
    void testReturnValueDependentOnMethodParameter(@Mock Comparable<String> comparable){
        when(comparable.compareTo("Mockito")).thenReturn(1);
        when(comparable.compareTo("Intellij")).thenReturn(2);

        Assertions.assertEquals(1,comparable.compareTo("Mockito"));
        Assertions.assertEquals(2,comparable.compareTo("Intellij"));
    }

    // return a value based on the type of the provide parameter
    @Test
    void testReturnValueDependentOnMethodParameter2(@Mock Comparable<Integer> comparable){
        when(comparable.compareTo(isA(Integer.class))).thenReturn(0);

        Assertions.assertEquals(0,comparable.compareTo(Integer.valueOf(4)));
    }

}

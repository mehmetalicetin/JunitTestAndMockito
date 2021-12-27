package mockito.vogella;

import com.cetin.vogella.DataBase;
import com.cetin.vogella.Service;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-24
 */

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    // activate the strict subs rule
    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    DataBase dataBaseMock = mock(DataBase.class);

    @Test
    @DisplayName("5.1")
    void testQuery() {
        Assertions.assertNotNull(dataBaseMock, " DataBase reference cannot be null");
        when(dataBaseMock.isAvailable()).thenReturn(true);
        Service service = new Service(dataBaseMock);
        boolean check = service.query("* from");
        Assertions.assertTrue(check, "The query format is wrong");
    }
}

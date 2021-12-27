package mockito.vogella;

import com.cetin.vogella.DataBase;
import com.cetin.vogella.Service;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.quality.Strictness;

import javax.xml.crypto.Data;

import static org.mockito.Mockito.when;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-24
 */

@ExtendWith(MockitoExtension.class)
public class ServiceDatabaseIdTest {

    // activate the strict subs rule
    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Mock
    DataBase dataBaseMock;


    @InjectMocks
    Service service;

    @Test
    @DisplayName("5.1")
    void ensureMockitoReturnsTheConfiguredValue() {
        when(dataBaseMock.getUniqueId()).thenReturn(53);
        Assertions.assertEquals(service.toString(),"Using database with id: "+53);
    }
}

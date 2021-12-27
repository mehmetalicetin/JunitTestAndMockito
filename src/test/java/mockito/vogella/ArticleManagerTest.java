package mockito.vogella;

import com.cetin.vogella.ArticleDatabase;
import com.cetin.vogella.ArticleManager;
import com.cetin.vogella.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-27
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("7 @InjectMocks")
public class ArticleManagerTest {

    @Mock
    ArticleDatabase articleDatabase;

    @Mock
    User user;

    @InjectMocks
    private ArticleManager articleManager;

    @Test
    void shouldDoSomething(){
        //TODO perform some tests with this managers
    }
}

package mockito.stub.business;

import com.cetin.unit.mockito.stub.ToDoBusinessImpl;
import com.cetin.unit.mockito.stub.ToDoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-22
 */
public class ToDoSBusinessImplStubTest {

    @Test
    void usingAStub() {
        ToDoService toDoService = new ToDoServiceStub();
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoService);
        List<String> todos = toDoBusiness.retrieveToDoRelatedToSpring("Ranga");
        Assertions.assertEquals(2, todos.size());
    }
}

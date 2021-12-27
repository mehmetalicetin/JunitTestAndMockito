package com.cetin.unit.mockito.stub;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-22
 */
public class ToDoBusinessImpl {
    private ToDoService toDoService;

    public ToDoBusinessImpl(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    public List<String> retrieveToDoRelatedToSpring(String user){
        List<String> filteredToDo = new ArrayList<>();
        List<String> allToDo = toDoService.retrieveTodos(user);
        for(String todo : allToDo){
            if(todo.contains("Spring")){
                filteredToDo.add(todo);
            }
        }
        return filteredToDo;
    }
}

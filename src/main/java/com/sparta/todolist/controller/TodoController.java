package com.sparta.todolist.controller;

import com.sparta.todolist.dto.TodoRequestDto;
import com.sparta.todolist.dto.TodoResponseDto;
import com.sparta.todolist.entity.Todo;
import com.sparta.todolist.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TodoController {

    public final Map<Long, Todo> todoList=new HashMap<>();

    @PostMapping("/todo")
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto requestDto){
        //RequestDto -> Entity
        Todo todo=new Todo(requestDto);

        //Memo Max Id Check
        Long maxId = todoList.size() > 0 ? Collections.max(todoList.keySet()) +1: 1;
        todo.setId(maxId);

        //DB 저장
        todoList.put(todo.getId(), todo);

        //Entity -> ResponseDto
        TodoResponseDto todoResponseDto = new TodoResponseDto(todo);

        return todoResponseDto;
    }

    @GetMapping("/todo")
    public List<TodoResponseDto> getSchedul(){
        List<TodoResponseDto> responseList= todoList.values().stream().map(TodoResponseDto::new).toList();

        return responseList;
    }

    @PutMapping("/todo/{id}")
    public Long updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto requestDto){
        //해당 메모가 DB에 존재하는지 확인
        if(todoList.containsKey(id)){
            Todo todo=todoList.get(id);

            //todo 수정
            todo.update(requestDto);
            return todo.getId();
        }else {
            throw new IllegalArgumentException("선택한 스케줄은 존재하지 않습니다.");
        }
    }

    @DeleteMapping("/todo/{id}")
    public Long deleteTodo(@PathVariable Long id){
        //해당 메모가 DB에 존재하는지 확인
        if(todoList.containsKey(id)){
            //todo 삭제
            todoList.remove(id);
            return id;
        }else {
            throw new IllegalArgumentException("선택한 스케줄은 존재하지 않습니다.");
        }
    }
}

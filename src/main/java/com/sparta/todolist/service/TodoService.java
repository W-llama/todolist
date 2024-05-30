package com.sparta.todolist.service;

import com.sparta.todolist.dto.TodoRequestDto;
import com.sparta.todolist.dto.TodoResponseDto;
import com.sparta.todolist.entity.Todo;
import com.sparta.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        // RequestDto -> Entity
        Todo todo = new Todo(requestDto);

        // DB 저장
        Todo saveTodo = todoRepository.save(todo);

        // Entity -> ResponseDto
        TodoResponseDto todoResponseDto = new TodoResponseDto(saveTodo);

        return todoResponseDto;
    }

    public List<TodoResponseDto> getTodo() {
        // DB 조회
        return todoRepository.findAllByOrderByModifiedAtDesc().stream().map(TodoResponseDto::new).toList();
    }

    public List<TodoResponseDto> getTodoByKeyword(String keyword) {
        return todoRepository.findAllByContentsContainsOrderByModifiedAtDesc(keyword).stream().map(TodoResponseDto::new).toList();
    }

    @Transactional
    public Long updateTodo(Long id, TodoRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Todo todo = findTodo(id);

        // 스케줄 내용 수정
        todo.update(requestDto);

        return id;
    }

    public Long deleteTodo(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Todo todo = findTodo(id);

        // 스케줄 삭제
        todoRepository.delete(todo);

        return id;
    }

    private Todo findTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }
}

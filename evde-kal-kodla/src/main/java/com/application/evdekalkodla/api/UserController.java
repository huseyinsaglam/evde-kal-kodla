package com.application.evdekalkodla.api;


import com.application.evdekalkodla.dto.UserDto;
import com.application.evdekalkodla.pagination.TPage;
import com.application.evdekalkodla.service.implementation.UserServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getByid(@PathVariable(value = "id", required = true) Long id) {
        UserDto user = userServiceImpl.getById(id);
        return ResponseEntity.ok(user);
    }


    @PostMapping
    public ResponseEntity<UserDto> createProject(@Valid @RequestBody UserDto user) {

        return ResponseEntity.ok(userServiceImpl.save(user));


    }



    @GetMapping("/pagination")
    public ResponseEntity<TPage<UserDto>> getAllByPagination(Pageable pageable) {
        TPage<UserDto> data = userServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }


    @GetMapping()
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> data = userServiceImpl.getAll();
        return ResponseEntity.ok(data);
    }



}

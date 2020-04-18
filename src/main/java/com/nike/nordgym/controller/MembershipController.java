package com.nike.nordgym.controller;

import com.nike.nordgym.model.MembershipDto;
import com.nike.nordgym.service.MembershipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memberships")
public class MembershipController {

    private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping("/all")
    public List<MembershipDto> getAll() {
        return this.membershipService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<MembershipDto> save(@RequestBody MembershipDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.membershipService.save(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MembershipDto> delete(@PathVariable(name = "id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.membershipService.delete(id));
    }

    @PatchMapping("/activate")
    public ResponseEntity<MembershipDto> activate(@RequestBody MembershipDto dto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.membershipService.activate(dto));
    }
}

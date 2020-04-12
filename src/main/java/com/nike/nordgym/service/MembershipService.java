package com.nike.nordgym.service;

import com.nike.nordgym.model.MembershipDto;

import java.util.List;

public interface MembershipService {

    List<MembershipDto> getAll();

    MembershipDto save(MembershipDto dto);

   MembershipDto delete(Long id);
}

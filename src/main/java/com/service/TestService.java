package com.service;

import com.dto.ClmStatementRela;

import java.util.List;

public interface TestService {

    List<ClmStatementRela> selectLocal(int id);
    void test();
}

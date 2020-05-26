package com.mapper;

import com.dto.ClmStatementRela;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ClmStatementRelaMapper {

   List<ClmStatementRela> selectLocal(int row);

    List<ClmStatementRela> selectLocal2(@Param("row") int row);

    int ins(ClmStatementRela clmStatementRela);
}

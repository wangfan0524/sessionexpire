package com.service.impl;

import com.dto.ClmStatementRela;
import com.mapper.ClmStatementRelaMapper;
import com.service.Test2Service;
import com.service.TestService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class TestServiceImpl implements TestService {

    @Autowired
    private ClmStatementRelaMapper clmStatementRelaMapper;

    @Autowired
    private Test2Service test2Service;
    @Override
    public List<ClmStatementRela> selectLocal(int id) {
        TestService self = (TestService) AopContext.currentProxy();

        /*SqlSession session = MybatisUtil.getSession();
        ClmStatementRelaMapper mapper = session.getMapper(ClmStatementRelaMapper.class);
        ClmStatementRela clmStatementRela = new ClmStatementRela();
        clmStatementRela.setStatementId(10001L);
        clmStatementRela.setClaimHeaderId(1234L);
        clmStatementRela.setRelativeId(1111L);

        List<ClmStatementRela> clmStatementRelas = mapper.selectLocal(100);
        session.commit();
        SqlSession session1 = MybatisUtil.getSession();
        List<ClmStatementRela> clmStatementRelas1 = mapper.selectLocal2(100);
        session1.commit();*/
        List<ClmStatementRela> clmStatementRelas = clmStatementRelaMapper.selectLocal(100);

        List<ClmStatementRela> clmStatementRelas1 = clmStatementRelaMapper.selectLocal2(100);
        test();
        return clmStatementRelas;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void test() {
       /* ClmStatementRela clmStatementRela = new ClmStatementRela();
        clmStatementRela.setRelativeId(125L);
        clmStatementRela.setClaimHeaderId(2L);
        clmStatementRela.setStatementId(3L);
        clmStatementRela.setClaimNum("test");
        clmStatementRelaMapper.ins(clmStatementRela);*/
    }

}

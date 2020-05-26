package com.dto;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Date;

public class ClmStatementRela {
    private Long relativeId;

    private Long statementId;

    private Long claimHeaderId;

    private Long programApplicationId;

    private Date programUpdateDate;

    private  String  claimNum;

    public Long getRelativeId() {
        return relativeId;
    }

    public void setRelativeId(Long relativeId) {
        this.relativeId = relativeId;
    }

    public Long getStatementId() {
        return statementId;
    }

    public void setStatementId(Long statementId) {
        this.statementId = statementId;
    }

    public Long getClaimHeaderId() {
        return claimHeaderId;
    }

    public void setClaimHeaderId(Long claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
    }

    public Long getProgramApplicationId() {
        return programApplicationId;
    }

    public void setProgramApplicationId(Long programApplicationId) {
        this.programApplicationId = programApplicationId;
    }

    public Date getProgramUpdateDate() {
        return programUpdateDate;
    }

    public void setProgramUpdateDate(Date programUpdateDate) {
        this.programUpdateDate = programUpdateDate;
    }


    public String getClaimNum() {
        return claimNum;
    }

    public void setClaimNum(String claimNum) {
        this.claimNum = claimNum;
    }
}

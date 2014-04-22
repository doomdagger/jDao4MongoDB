package com.fan1tuan.business.support;

import com.fan1tuan.business.support.enums.ResultStatus;

/**
 * Created by Li He on 2014/4/22.
 * @author Li He
 */
public class StatusAwareResult<U> {
    private ResultStatus status;
    private U ret;

    public StatusAwareResult(ResultStatus status, U ret) {
        this.status = status;
        this.ret = ret;
    }

    public StatusAwareResult() {
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    public U getRet() {
        return ret;
    }

    public void setRet(U ret) {
        this.ret = ret;
    }

    public String toString() {

        return "Status Aware Result:\n" + "\tStatus:\t" + getStatus() + "(" + getStatus().rawMessage() + ")\n" + "\tResult:\t" + ret;
    }
}

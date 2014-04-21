package com.fan1tuan.business.support;

import com.fan1tuan.pojos.support.EntityObject;

/**
 * Created by Li He on 2014/4/22.
 * @author Li He
 */
public class StatusAwareResult<T,U> extends EntityObject{
    private T status;
    private U ret;

    public StatusAwareResult(T status, U ret) {
        this.status = status;
        this.ret = ret;
    }

    public StatusAwareResult() {
    }

    public T getStatus() {
        return status;
    }

    public void setStatus(T status) {
        this.status = status;
    }

    public U getRet() {
        return ret;
    }

    public void setRet(U ret) {
        this.ret = ret;
    }
}

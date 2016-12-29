package com.goeuro.direct.api;

import javax.ws.rs.QueryParam;

/**
 * Created by segr on 21.12.16.
 */
public class DirectConnectionRequest {
    @QueryParam("dep_sid")
    private Integer depSid;
    @QueryParam("arr_sid")
    private Integer arrSid;

    public Integer getDepSid() {
        return depSid;
    }

    public void setDepSid(Integer depSid) {
        this.depSid = depSid;
    }

    public Integer getArrSid() {
        return arrSid;
    }

    public void setArrSid(Integer arrSid) {
        this.arrSid = arrSid;
    }
}

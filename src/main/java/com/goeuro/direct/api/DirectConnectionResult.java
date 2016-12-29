package com.goeuro.direct.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by segr on 21.12.16.
 */
public class DirectConnectionResult {
    private Integer depSid;
    private Integer arrSid;
    private Boolean directBusRoute;

    @JsonProperty("dep_sid")
    public Integer getDepSid() {
        return depSid;
    }

    public void setDepSid(Integer depSid) {
        this.depSid = depSid;
    }

    @JsonProperty("arr_sid")
    public Integer getArrSid() {
        return arrSid;
    }

    public void setArrSid(Integer arrSid) {
        this.arrSid = arrSid;
    }

    @JsonProperty("direct_bus_route")
    public Boolean getDirectBusRoute() {
        return directBusRoute;
    }

    public void setDirectBusRoute(Boolean directBusRoute) {
        this.directBusRoute = directBusRoute;
    }
}

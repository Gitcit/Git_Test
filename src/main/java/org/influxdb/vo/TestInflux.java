package org.influxdb.vo;

import java.util.Date;

public class TestInflux {
    private Date time;
    private String hostname;
    private int queryFail;
    private int queryOK;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getQueryFail() {
        return queryFail;
    }

    public void setQueryFail(int queryFail) {
        this.queryFail = queryFail;
    }

    public int getQueryOK() {
        return queryOK;
    }

    public void setQueryOK(int queryOK) {
        this.queryOK = queryOK;
    }
}

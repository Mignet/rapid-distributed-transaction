package com.hd.domain.vo;

import java.io.Serializable;
import java.util.Date;

public class TicketVo implements Serializable{

    private String id;

 
    private Date createTime;

    
    private String userId;

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

  
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
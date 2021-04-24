package com.iods.iods_backend.upload.entity;

import lombok.Data;

@Data
public class ReturnMessage {
    private boolean success;
    private Object data;

    public ReturnMessage success(Object data){
        this.success = true;
        this.data = data;
        return this;
    }
    public ReturnMessage success(){
        this.success = true;
        this.data = null;
        return this;
    }
    public ReturnMessage faild(Object data){
        this.success = false;
        this.data = data;
        return this;
    }
}

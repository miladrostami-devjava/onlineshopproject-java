package com.shop.app.helper.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServiceResponse<T> implements Serializable {
    //ServiceResponse or APIResponse
private List<T> dataList;
private ResponseStatus status;
private boolean hasError;
private String message;
private long totalCount;


    public ServiceResponse( ResponseStatus status ,List<T> dataList) {
        this.status = status;
        this.dataList = dataList;
        this.message = "";
        this.hasError = status != ResponseStatus.SUCCESS;
        this.totalCount = 0;
    }
    public ServiceResponse( ResponseStatus status ,List<T> dataList,long totalCount) {
        this.status = status;
        this.dataList = dataList;
        this.message = "";
        this.hasError = status != ResponseStatus.SUCCESS;;
        this.totalCount = totalCount;
    }

    public ServiceResponse( ResponseStatus status ,T data) {
        this.status = status;
     this.dataList = new ArrayList<T>();
     this.dataList.add(data);
        this.message = "";
        this.hasError = status != ResponseStatus.SUCCESS;;
        this.totalCount = 1;
    }

    //todo : problem is in this
    public ServiceResponse( ResponseStatus status ,String message) {
        this.status = status;
        this.dataList = new ArrayList<T>();
      this.message = message;
        this.hasError = status == ResponseStatus.FAILED ;
        this.totalCount = 0;
    }
    public ServiceResponse(Exception ex) {
        this.status = ResponseStatus.EXCEPTION;
        this.dataList = new ArrayList<T>();
        this.message = ex.getMessage();
        this.hasError = true;
        this.totalCount = 0;
    }
    public List<T> getDataList() {
        return dataList;
    }
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
    public ResponseStatus getStatus() {
        return status;
    }
    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
    public boolean isHasError() {
        return hasError;
    }
    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public long getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}

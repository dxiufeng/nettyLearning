package com.netty.pojo;

import java.util.List;

public class Customer {
    private long customerId;
    private String customerXinshi;
    private String customerName;
    private List<String> totalName;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerXinshi='" + customerXinshi + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalName=" + totalName +
                '}';
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerXinshi() {
        return customerXinshi;
    }

    public void setCustomerXinshi(String customerXinshi) {
        this.customerXinshi = customerXinshi;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getTotalName() {
        return totalName;
    }

    public void setTotalName(List<String> totalName) {
        this.totalName = totalName;
    }
}

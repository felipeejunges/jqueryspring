package br.com.felipejunges.simplespring.domain;

import java.io.Serializable;

public class Registro implements Serializable {

    long id;
    String dataTime;
    String mate;
    long total_weight;
    long axle_number;
    boolean overloaded;
    String formFactor;
    String sanpshot1;

    public Registro() {
    }

    public Registro(long id, String dataTime, String mate, long total_weight, long axle_number,
                    boolean overloaded, String formFactor, String sanpshot1) {
        this.id = id;
        this.dataTime = dataTime;
        this.mate = mate;
        this.total_weight = total_weight;
        this.axle_number = axle_number;
        this.overloaded = overloaded;
        this.formFactor = formFactor;
        this.sanpshot1 = sanpshot1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getdataTime() {
        return dataTime;
    }

    public void setdataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getMate() {
        return mate;
    }

    public void setMate(String mate) {
        this.mate = mate;
    }

    public long getTotal_weight() {
        return total_weight;
    }

    public void setTotal_weight(long total_weight) {
        this.total_weight = total_weight;
    }

    public long getAxle_number() {
        return axle_number;
    }

    public void setAxle_number(long axle_number) {
        this.axle_number = axle_number;
    }

    public boolean isOverloaded() {
        return overloaded;
    }

    public void setOverloaded(boolean overloaded) {
        this.overloaded = overloaded;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getSanpshot1() {
        return sanpshot1;
    }

    public void setSanpshot1(String sanpshot1) {
        this.sanpshot1 = sanpshot1;
    }
}
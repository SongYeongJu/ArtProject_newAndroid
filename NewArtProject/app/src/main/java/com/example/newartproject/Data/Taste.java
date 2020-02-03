package com.example.newartproject.Data;

public class Taste {
    private String tasteName;
    private int src;
    public Taste(){}
    public Taste(String tasteName, int src){
        this.tasteName=tasteName;
        this.src=src;
    }
    public String getTasteName(){ return tasteName;}
    public int getSrc(){ return src; }
    public void setTasteName(String tasteName) { this.tasteName=tasteName; }
    public void setSrc(int src) { this.src=src; }
}

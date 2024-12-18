package com.example.OldFashionPound;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OldFashionPound {
    private int sterline;
    private int scellini;
    private int pence;

    public OldFashionPound(int totalpence){
        this.sterline = totalpence/240;
        int reminder = totalpence%240;
        this.scellini = reminder/12;
        this.pence = reminder%12;
    }

    public OldFashionPound(int sterline,int scellini,int pence) {
        this.pence = pence % 12;
        this.scellini = (scellini + pence/12) % 20;
        this.sterline = sterline + (scellini + pence/12)/20;
    }

    private int transformInPence() {
        return this.sterline*240 + this.scellini*12 + this.pence;
    }

    public OldFashionPound add(OldFashionPound p) {
        return new OldFashionPound(transformInPence() + p.transformInPence());
    }

    public OldFashionPound subtract(OldFashionPound p) {
        int price1InPence = transformInPence();
        int price2InPence = p.transformInPence();
        return new OldFashionPound(price1InPence - price2InPence);
    }

    public OldFashionPound multiply(int multiplier){
        if (multiplier <= 0) throw new IllegalArgumentException("Multiplier must be a positive integer.");
        int resultInPence = transformInPence() * multiplier;
        return new OldFashionPound(resultInPence);
    }

    public String divide(int divisor){
        if (divisor <= 0) throw new IllegalArgumentException("Divisor must be a positive integer.");
        int priceInPence = transformInPence();
        int resultInPence = priceInPence/divisor;
        OldFashionPound result = new OldFashionPound(resultInPence);
        int reminderInPence = priceInPence%divisor;
        OldFashionPound reminder = new OldFashionPound(reminderInPence);
        return result + "(" + reminder + ")";
    }

    @Override
    public String toString(){
        String sterline = this.sterline != 0? this.sterline + "p " : "";
        String scellini = this.scellini != 0? this.scellini + "s " : "";
        String pence = this.pence != 0? this.pence + "d" : "";
        return sterline + scellini + pence;
    }
}

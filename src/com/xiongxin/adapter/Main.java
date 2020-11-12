package com.xiongxin.adapter;

public class Main {

    public static void main(String[] args) {
        var captain = new Captain(new FishingBoatAdapter(new FishingBoat()));
        captain.row();
    }
}

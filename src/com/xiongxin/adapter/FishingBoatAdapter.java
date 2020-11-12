package com.xiongxin.adapter;

public class FishingBoatAdapter implements RowingBoat {
    private final FishingBoat boat;

    public FishingBoatAdapter(FishingBoat boat) {
        this.boat = boat;
    }

    @Override
    public void row() {
        boat.sail();
    }
}

package com.xiongxin.adapter;

public class Captain {
    private final RowingBoat rowingBoat;

    // 这里代表这个船长仅仅会划船，并不会开船
    public Captain(RowingBoat rowingBoat) {
        this.rowingBoat = rowingBoat;
    }

    public void row() {
        rowingBoat.row();
    }
}

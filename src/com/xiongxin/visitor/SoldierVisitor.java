package com.xiongxin.visitor;

public class SoldierVisitor implements UnitVisitor {
    @Override
    public void visitSoldier(Soldier soldier) {
        System.out.println("Hello " + soldier);
    }

    @Override
    public void visitSergeant(Sergeant sergeant) {

    }

    @Override
    public void visitCommander(Commander commander) {

    }
}

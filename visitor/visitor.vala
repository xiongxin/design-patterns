
// Unit and UnitVisitor base types.

public abstract class Unit {
    private Unit[] children { get; set; }

    Unit(Unit[] children) {
        this.children = children;
    }

    public virtual void accept(UnitVisitor visitor) {
        foreach (Unit child in children) {
            child.accept(visitor);
        }
    }
}

public interface UnitVisitor {
    public abstract void visitSoldier(Soldier soldier);
    public abstract void visitCommander(Commander commander);
    public abstract void visitSergeant(Sergeant sergeant);
}

// 指挥官下面有两个军士
public class Commander : Unit {
    public Commander(Unit[] children) {
        base(children);
    }

    public override void accept(UnitVisitor visitor) {
        visitor.visitCommander(this);  // 首先访问当前类
        base.accept(visitor);          // 访问children
    }

    public string to_string() {
        return "commander";
    }
}

// 军士下面有两个士兵
public class Sergeant : Unit {
    public Sergeant(Unit[] children) {
        base(children);
    }

    public override void accept(UnitVisitor visitor) {
        visitor.visitSergeant(this);
        base.accept(visitor);
    }

    public string to_string() {
        return "sergeant";
    }
}

// 士兵的children也有直
public class Soldier : Unit {
    public Soldier(Unit[] children) {
        base(children);
    }

    public override void accept(UnitVisitor visitor) {
        visitor.visitSoldier(this);
        base.accept(visitor);
    }

    public string to_string() {
        return "soldier";
    }
}

// 具体访问指挥官时的类
public class CommanderVisitor : UnitVisitor {
    public void visitCommander(Commander commander) {
        stdout.printf(@"Good to see you $commander\n");
    }
    public void visitSoldier(Soldier soldier) {}
    public void visitSergeant(Sergeant sergeant) {}
}

public class SergeantVisitor : UnitVisitor {
    public void visitCommander(Commander commander) {}
    public void visitSoldier(Soldier soldier) {}
    public void visitSergeant(Sergeant sergeant) {
        stdout.printf(@"Good to see you $sergeant\n");
    }
}

public class SoldierVisitor : UnitVisitor {
    public void visitCommander(Commander commander) {}
    public void visitSoldier(Soldier soldier) {
        stdout.printf(@"Good to see you $soldier\n");
    }
    public void visitSergeant(Sergeant sergeant) {}
}



void main() {
    var soldier1 = new Soldier({});
    var soldier2 = new Soldier({});
    var soldier3 = new Soldier({});
    var soldier4 = new Soldier({});
    var sergeant1 = new Sergeant({ soldier1, soldier2 });
    var sergeant2 = new Sergeant({ soldier3, soldier4 });
    var commander = new Commander({ sergeant1, sergeant2 });

    commander.accept(new SoldierVisitor());
    commander.accept(new SergeantVisitor());
    commander.accept(new CommanderVisitor());
}
package be.ieps.poo.arnaud.model.decorator;


import be.ieps.poo.arnaud.model.plats.Plat;

public abstract class PlatDecorator implements Plat {

    protected Plat platDecore;

    public PlatDecorator(Plat platDecore) {
        this.platDecore = platDecore;
    }

}

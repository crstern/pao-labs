package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;


class Sir {
    private String sir;

    public Sir(String sir) {
        this.sir = sir;
    }

    public void modificaSir(String sir) {
        this.sir = sir;
    }

    public void modificaSir(Sir sir) {
        sir = new Sir("Mihai");
    }

    public String getSir() {
        return sir;
    }
}

public class Main{
    public static void main(String [] args){
        BiFunction<Persoana, Double, Double> f = (p, m) -> p.getSalariu()*(1 + m/100.0);
        BiPredicate<Double, Double> p = (s, m) -> s <= m;
        BiConsumer<Persoana, Double> c = (t, m) -> t.setSalariu(t.getSalariu()*(1 + m/100.0));
        ArrayList<Persoana> lp = new ArrayList<Persoana>();
        lp.add(new Persoana("gigel", 16, 5010));
        lp.add(new Persoana("mihael", 18, 4010));
        lp.add(new Persoana("cosicla", 120, 8010));


        for(Persoana pc : lp){
//            if(p.test(f.apply(pc, 50.0), 5000.0)) c.accept(pc, 50.0);
            if(f.apply(pc,50.0).test(pc, 50.0)) c.accept(pc,50.0);
            System.out.println(pc.salariu);
        }
    }
}

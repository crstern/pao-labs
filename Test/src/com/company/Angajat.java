package com.company;

class Angajat {
    int salariu;
    void afiseazaSalariu() {
        System.out.println(this.salariu);
    }
}

class Economist extends Angajat {
    int spor;
    void afiseazaSalariu() {
        System.out.println(this.salariu + this.spor);
    }

    void afiseazaSalariu(int bonus) {
        System.out.println(this.salariu + this.spor + bonus);
    }

    int afiseazaSalariu(String mesaj) {
        int aux = this.salariu + this.spor;
        System.out.println(mesaj + aux);
        return aux;
    }
}
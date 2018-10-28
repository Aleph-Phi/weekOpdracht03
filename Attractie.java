import java.util.Scanner;

public class Attractie {
    String naam;
    double prijs;
    int oppervlakte;
    int onbelasteTicketsVerkocht=0;
    Kassa kassa = new Kassa();

    void draaien(){
        System.out.println("De attractie " + naam + " draait nu");
        kassa.balans+=prijs;
        kassa.kaartjesVerkocht++;
        if (this instanceof GokAttractie){
            this.onbelasteTicketsVerkocht++;
        }
    }

}

class Botsauto extends Attractie {
    int oppervlakte=44;
}

class Spin extends RisicoRijkeAttractie{

    Spin() {
        int oppervlakte = 54;
        int draailimiet = 5;
    }

}

class Spiegelpaleis extends Attractie{
    int oppervlakte=62;

}

class Spookhuis extends Attractie{
    int oppervlakte=54;
}

class Hawaii extends RisicoRijkeAttractie {
    Hawaii() {
        int oppervlakte = 48;
        int draailimiet = 10;
    }


}

class Ladderklimmen extends Attractie implements GokAttractie{
    int oppervlakte=24;

    public void kansSpelBelastingBetalen(){
        kassa.balans*=0.7;
    }
}

abstract class RisicoRijkeAttractie extends Attractie{
    int draailimiet;
    int kerenGedraaid=0;
    boolean gekeurd=true;

    RisicoRijkeAttractie() {
        try {
            opstellingskeuring();
        } finally {
            return;
        }
    }

    boolean opstellingskeuring() throws OnderhoudNoodzakelijkException {
        if (draailimiet-kerenGedraaid==0){
            throw new OnderhoudNoodzakelijkException();
        } else {
            return gekeurd=true;
        }

    }

    void draaien(){
        try {
            opstellingskeuring();
        } catch (OnderhoudNoodzakelijkException one) {
            MonteurOptrommelen();
        } finally {
            if (this.gekeurd==true) {
                System.out.println("De attractie " + naam + " draait nu");
                kassa.balans += prijs;
                kassa.kaartjesVerkocht++;
                kerenGedraaid++;
            }
        }
    }

    void MonteurOptrommelen(){
        System.out.println("De attractie " + naam + " dient gekeurd te worden, wilt u een monteur bellen?");
        System.out.println("Toets 'm' om een monteur te bellen, of druk ENTER om de attractie buiten werking te stellen");
        Scanner sc = new Scanner(System.in);
        String invoer = sc.nextLine();
        if (invoer.equals("m")) {
            this.gekeurd = new Monteur().KeuringEnOnderhoud(this);
        } else if (invoer.equals("")){
            return;
        } else {
            System.out.println("Het is me niet duidelijk wat u precies bedoelt, probeer het nogmaals");
            MonteurOptrommelen();
        }
    }

}

interface GokAttractie {


}

class OnderhoudNoodzakelijkException extends Exception{}


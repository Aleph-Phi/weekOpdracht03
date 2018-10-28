import java.util.ArrayList;

public class Kassa {

    double balans;
    int kaartjesVerkocht;
}

class HoofdKassa extends Kassa{
    int belastingInspecteurBezoeken=-1;
    double belastingGeheven;


    void balansOpmaken(ArrayList<Attractie> attracties){
        double nieuweOmzet=0;
        int huidigeKaartjesVerkoop=0;

        for (Attractie attractie: attracties){
            nieuweOmzet+=attractie.kassa.balans;
            huidigeKaartjesVerkoop+=attractie.kassa.kaartjesVerkocht;

        }
        this.balans=nieuweOmzet;
        this.kaartjesVerkocht=huidigeKaartjesVerkoop;


    }

    void omzetWeergeven(ArrayList<Attractie> attracties){
        for (Attractie attractie: attracties){
            double aK=(double) Math.round(attractie.kassa.balans * 100d) / 100d;
            System.out.println(attractie.naam + " heeft €" + aK + " aan inkomsten gegenereerd");
        }
        double hK=(double) Math.round(balans * 100d) / 100d;
        System.out.println("De kermis heeft in totaal €" + hK + " omgezet");
        System.out.println();
        System.out.println("De belasting inspecteur is " + belastingInspecteurBezoeken + " keer langs geweest");
        double bG=(double) Math.round(belastingGeheven * 100d) / 100d;
        System.out.println("Er is een totaal van €" +bG + " aan belasting geheven");
        System.out.println();

    }

    void kaartVerkoopWeergeven(ArrayList<Attractie> attracties) {
        for (Attractie attractie : attracties) {
            System.out.println(attractie.naam + " heeft " + attractie.kassa.kaartjesVerkocht + " kaarten verkocht");
        }
        System.out.println("De kermis heeft in totaal " + kaartjesVerkocht + " kaarten vekorcht");
    }
}

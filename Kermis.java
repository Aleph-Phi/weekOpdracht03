import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Kermis {

    HoofdKassa kermisKassa= new HoofdKassa();

    ArrayList<Attractie> kermisAttracties = new ArrayList<>();

    int belastingsInspectieCD=0;

    void opBouwen(){

        Spin tarantula = new Spin();
        tarantula.naam="Terrifying Tarantula";
        tarantula.prijs=2.25;
        tarantula.draailimiet=5;
        Spiegelpaleis mirrorMirror = new Spiegelpaleis();
        mirrorMirror.naam = "Palace of Mirrors";
        mirrorMirror.prijs = 2.75;
        Ladderklimmen climbUp = new Ladderklimmen();
        climbUp.naam = "Climb to Success";
        climbUp.prijs = 5.00;
        Botsauto bumpCars = new Botsauto();
        bumpCars.naam = "Wheels of Destruction";
        bumpCars.prijs = 2.50;
        Hawaii maui = new Hawaii();
        maui.naam = "Magical Maui";
        maui.prijs = 2.90;
        maui.draailimiet=10;
        Spookhuis bloodGate = new Spookhuis();
        bloodGate.naam = "The Blood Gate";
        bloodGate.prijs = 3.20;

        Collections.addAll(kermisAttracties, bumpCars, tarantula, mirrorMirror, bloodGate, maui, climbUp );

    }

    void bezoeken(){
        belastingsBezoekBepalen();
        kiesAttractie();
        inzageGegevens();
        belastingsInspectieCD--;
        bezoeken();
    }



    void kiesAttractie(){
        System.out.println("Welke attractie wil je bezoeken?");
        System.out.println("Toets het cijfer in dat overeenkomt met uw keuze");
        System.out.println("1. Voor de botsauto's");
        System.out.println("2. Voor de spin");
        System.out.println("3. Voor het spiegelpaleis");
        System.out.println("4. Voor het spookhuis");
        System.out.println("5. Voor Hawaii");
        System.out.println("6. Voor ladderklimmen");
        Scanner inv = new Scanner(System.in);
        String invoer =inv.nextLine();

        if (invoer.equals("1")){
            kermisAttracties.get(0).draaien();
            System.out.println(kermisAttracties.get(0).naam);

        } else if (invoer.equals("2")){
            kermisAttracties.get(1).draaien();

        } else if (invoer.equals("3")){
            kermisAttracties.get(2).draaien();

        } else if (invoer.equals("4")){
            kermisAttracties.get(3).draaien();

        } else if (invoer.equals("5")){
            kermisAttracties.get(4).draaien();

        } else if (invoer.equals("6")){
            kermisAttracties.get(5).draaien();
        }
        this.kermisKassa.balansOpmaken(kermisAttracties);
        }


    void inzageGegevens(){
        System.out.println("Wilt u inzage in de omzet of inzicht over hoeveel kaartjes er zijn verkocht? ");
        System.out.println("Toets 'o' voor de omzet, 'k' voor de kaartjes en ENTER om simpelweg door te gaan");
        Scanner inv = new Scanner(System.in);
        String invoer=inv.nextLine();

        if (invoer.equals("o")){
            this.kermisKassa.omzetWeergeven(kermisAttracties);
        } else if (invoer.equals("k")){
          this.kermisKassa.kaartVerkoopWeergeven(kermisAttracties);
        } else if (invoer.equals("")){
            return;
        } else {
            System.out.println("Helaas herken ik die invoer niet, probeer het nogmaals");
            inv = new Scanner(System.in);
            inzageGegevens();
        }
    }

    void belastingsBezoekBepalen(){
        if (belastingsInspectieCD==0){
            double betaaldeBelasting=new BelastingInspecteur().belastingHeffen(kermisAttracties);
            kermisKassa.belastingGeheven+=betaaldeBelasting;
            kermisKassa.balans=(kermisKassa.balans - betaaldeBelasting);
            belastingsInspectieCD=(new Random().nextInt(15)+1);
            kermisKassa.belastingInspecteurBezoeken++;
        } else {
            return;
        }
    }

    public static void main(String[] args) {

      Kermis deKermis = new Kermis();
      deKermis.opBouwen();
      deKermis.bezoeken();

    }




}

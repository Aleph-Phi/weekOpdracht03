import java.util.ArrayList;

public class BelastingInspecteur {

    double belastingHeffen(ArrayList<Attractie> attracties) {
        double verekeningTotaal = 0;
        for (Attractie attractie : attracties) {
            if (attractie instanceof GokAttractie) {
                double verekening = ((attractie.onbelasteTicketsVerkocht * attractie.prijs) * 0.30);
                attractie.onbelasteTicketsVerkocht = 0;
                verekeningTotaal += verekening;
            }
        }
        return verekeningTotaal;
    }
}
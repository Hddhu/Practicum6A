package Practicum6A;
import java.time.LocalDate;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;
    private double huidigePrijs;

    public Game(String nm, int rJ, double nwpr) {
        naam = nm;
        releaseJaar = rJ;
        nieuwprijs = nwpr;
    }
    public String getNaam(){
        return naam;
    }
    public double huidigeWaarde() {
        int jaar = LocalDate.now().getYear() - releaseJaar;
        double nieuwePrijs = nieuwprijs;
        if (jaar == 0){
            nieuwePrijs = nieuwePrijs - (nieuwePrijs*0.0);
        } else{
            for (int i = 0; i < jaar; i++) {
                nieuwePrijs = nieuwePrijs - (nieuwePrijs*0.3);
            }
        }
        return nieuwePrijs;
    }
    public boolean equals(Object andereObject)  {
        boolean gelijkeObjecten = false;
        if (andereObject instanceof Game)   {
            Game andereGame = (Game) andereObject;

            if  (this.naam.equals(andereGame.naam) &&
                 this.releaseJaar == andereGame.releaseJaar)  {
               gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;
    }
    public String toString() {
        return getNaam() + ", uitgegeven in " + releaseJaar + "; nieuwprijs: €" + String.format("%.2f", nieuwprijs) + " nu voor: €" + String.format("%.2f",huidigeWaarde());
    }
}
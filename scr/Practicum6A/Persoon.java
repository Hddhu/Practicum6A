package Practicum6A;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames;

    public Persoon(String nm, double bud){
        naam = nm;
        budget = bud;
        mijnGames = new ArrayList<Game>();
    }
    public double getBudget() {
        return budget;
    }
    public boolean koop(Game g){
        if (budget >= g.huidigeWaarde() && !mijnGames.contains(g)){
            budget = budget - g.huidigeWaarde();
            mijnGames.add(g);
            return true;
        } else {
            return false;
        }
    }
    public boolean verkoop(Game g, Persoon koper){
        if (mijnGames.contains(g) && koper.budget >= g.huidigeWaarde() && !koper.mijnGames.contains(g)) {
            mijnGames.remove(g);
            koper.budget = koper.budget - g.huidigeWaarde();
            budget = budget + g.huidigeWaarde();
            koper.mijnGames.add(g);
            return true;
        } else {
            return false;
        }
    }
    public Game zoekGameOpNaam(String g){
        Game spel = null;
        for (Game game : mijnGames){
            if (game.getNaam().equals(g)){
                spel = game;
            } else {
                spel = null;
            }
        }
        return spel;
    }

    public ArrayList bepaalGamesNietInBezit(ArrayList<Game> g){
        ArrayList gamesNietInBezit = new ArrayList<Game>();
        for(Game i : g){
            if(!mijnGames.contains(i)){
                gamesNietInBezit.add(i);
            }
        }
        return gamesNietInBezit;
    }

    public String toString() {
        String persoon = naam + " heeft een budget van €" + String.format("%.2f", budget) + " en bezit de volgende games:";
        for (Game games : mijnGames) {
            persoon = persoon + "\n" + games;
        }
        return persoon;
    }
}
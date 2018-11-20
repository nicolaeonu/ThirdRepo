package com.nicolae;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        FootballPlayer joe = new FootballPlayer("Alex");
        BaseBallPlayer rick = new BaseBallPlayer("Valentin");
        SoccerPlayer beck = new SoccerPlayer("Radu");

        Team<FootballPlayer> steauaBuc = new Team<>("Steaua Bucharest");
        steauaBuc.addPlayer(joe);

        Team<BaseBallPlayer> baseball = new Team<>("Baseball Bucharest");
        baseball.addPlayer(rick);

        Team<SoccerPlayer> soccer = new Team<>("Soccer Bucharest");
        soccer.addPlayer(beck);

        Team<FootballPlayer> melborne = new Team<>("Melborne");
        FootballPlayer banks = new FootballPlayer( "George");
        melborne.addPlayer(banks);

        Team<FootballPlayer> hawthorn = new Team<>("Hawton Horn");
        Team<FootballPlayer> fremantle = new Team<>("Freemantle");

        hawthorn.matchResult(fremantle,1,0);
        hawthorn.matchResult(steauaBuc,0,5);

        steauaBuc.matchResult(fremantle,3,1);

        System.out.println("rankings");
        System.out.println(steauaBuc.getName() + ": "+ steauaBuc.ranking());
        System.out.println(fremantle.getName() + ": "+ fremantle.ranking());
        System.out.println(hawthorn.getName() + ": "+ hawthorn.ranking());

        System.out.println(steauaBuc.compareTo(fremantle));
        System.out.println(steauaBuc.compareTo(hawthorn));




//        ArrayList<Integer> items = new ArrayList<>();
//        items.add(1);
//        items.add(2);
//        items.add(3);
//        items.add(4);
//        items.add(5);
//
//        printDouble(items);
//
//
//    }
//    private static void printDouble(ArrayList<Integer> n){
//        for(int i : n){
//            System.out.println(i *2);
//        }
    }
}

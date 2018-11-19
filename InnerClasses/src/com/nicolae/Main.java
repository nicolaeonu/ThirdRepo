package com.nicolae;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("Povesti", "Proconsul");
        album.addSong("Daca va fi soare", 3.04);
        album.addSong("Dor de tine", 2.49);
        album.addSong("Doua Lacrimi", 3.42);
        album.addSong("Epilog", 2.23);
        album.addSong("Nu mi-e bine fara tine", 2.23);
        album.addSong("Pentru ea", 4.03);
        album.addSong("Povestea Noastra", 3.42);
        album.addSong("Reteta Iubirii", 3.42);
        album.addSong("Stelele si luna", 3.59);
        album.addSong("Vraja ta", 2.49);
        albums.add(album);

        album = new Album("3REI Sud Est", "3trei Sud Est");
        album.addSong("3SE", 3.48);
        album.addSong("Ai Plecat", 3.39);
        album.addSong("Vino Langa Mine", 3.36);
        album.addSong("Te Chem Acum", 3.31);
        album.addSong("Crede-ma", 3.55);
        album.addSong("Te Vreau In Viata Mea", 3.30);
        album.addSong("Lory", 3.59);
        album.addSong("Nu Te Mai Iubesc", 5.32);
        album.addSong("Night of the long knives", 3.27);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Nu mi-e bine fara tine", playList);
        albums.get(0).addToPlayList("Daca va fi soare", playList);
        albums.get(0).addToPlayList("Animal X", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);  // There is no track 24

        play(playList);

    }


    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");

    }


    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("*********************");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("*********************");
    }

}


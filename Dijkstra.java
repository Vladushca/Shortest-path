import java.io.*;
import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class Dijkstra {
    public static Map<Integer, Vertex> strazi = new HashMap();
    public static Map<String, Integer> gabarite = new HashMap();
    public static int gabarit = 1;
    public static int cost = 1;
    public static int nr_noduri = 0;
    public static int nr_strazi = 0;
    public static int ambuteiaj = 0;

    public static void main(String[] args) {
        File file = new File("map.in");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st = null;
        boolean first_it = true;
        int k = 0;

        while (true) {
            try {
                assert br != null;
                if ((st = br.readLine()) == null) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (first_it) {
                assert st != null;
                nr_strazi = Integer.parseInt(st.substring(0, st.indexOf(" ")));
                nr_noduri = Integer.parseInt(st.substring(st.indexOf(" ") + 1));
                for (int i = 0; i < nr_noduri; i++) {
                    addNode(i);
                }
                first_it = false;
            } else if (k != nr_strazi) {
                st = st.replace("P", "");

                String[] splits = st.split(" ");

                addStreet(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]), Integer.parseInt(splits[2]), Integer.parseInt(splits[3]), ambuteiaj);
                k++;
            } else {
                if (st.contains("drive")) {
                    st = st.replace("drive ", "");
                    st = st.replace("P", "");
                    String[] splits = st.split(" ");
                    if (splits[0].equals("b")) {
                        gabarit = 1;
                        cost = 1;
                    }
                    if (splits[0].equals("m")) {
                        gabarit = 1;
                        cost = 2;
                    }
                    if (splits[0].equals("a")) {
                        gabarit = 2;
                        cost = 4;
                    }
                    if (splits[0].equals("c")) {
                        gabarit = 3;
                        cost = 6;
                    }

                   drive(Integer.parseInt(splits[1]), Integer.parseInt(splits[2]));

                }
                if (st.contains("accident") || st.contains("trafic") || st.contains("blocaj")) {
                    st = st.replace("P", "");
                    String[] splits = st.split(" ");
                    addRestriction(Integer.parseInt(splits[1]), Integer.parseInt(splits[2]), Integer.parseInt(splits[3]));
                }
            }
        }
    }

    /**
     * This method writes in the map.out the value of cost of a path
     * @param src is the start vertex
     * @param trg is the target vertex
     */
    public static void drive(int src, int trg) {
        PathFinder shortestPath = new PathFinder();
        shortestPath.ShortestP(strazi.get(src));

        File file = new File("map.out");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            if (strazi.get(trg).getDist() >= Double.MAX_VALUE) {
                br.write(strazi.get(src).getName() + " " + strazi.get(trg).getName() + " null");
                br.newLine();
                br.close();
                fr.close();
            } else {
                br.write(shortestPath.getShortestP(strazi.get(trg)) + " ");
                br.write(String.valueOf((int) strazi.get(trg).getDist()));
                br.newLine();
                br.close();
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < nr_noduri; i++) {
            strazi.get(i).setVisited(false);
            strazi.get(i).setPr(null);
            strazi.get(i).setDist(Double.MAX_VALUE);

        }
    }

    /**
     * This method adds a restrioction, such as an accident, blocaj or trafic
     * @param start is the start vertex of the restriction
     * @param end is the destination vertex of the restriction
     * @param cost is the cost of the restriction
     */
    public static void addRestriction(int start, int end, int cost) {
        gabarite.put(start + "-" + end, cost);
    }

    /**
     * This method adds a new street
     * @param src is the start vertex of the street
     * @param trg is the destination/target vertex of the street
     * @param cost is the cost of the street
     * @param gabarit is the admissible gabarit of that street
     * @param ambuteiaj is the restriction on that street
     */
    public static void addStreet(int src, int trg, int cost, int gabarit, int ambuteiaj) {
        strazi.get(src).addNeighbour(new Edge(cost, gabarit, strazi.get(src), strazi.get(trg), ambuteiaj));
    }

    /**
     * This method adds a node tot the graph
     @param nod  is the Node's index that is to be added
     */
    public static void addNode(int nod) {
        strazi.put(nod, new Vertex("P" + nod));
    }

}
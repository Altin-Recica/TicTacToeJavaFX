package be.kdg.TTT.model;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Altin Reçica
 * 3/15/2023
 */
public class LeaderboardFileManager {
    public void writeToFile(Player winner, Player player1, Player player2, int p1Score, int p2Score, int tieScore){
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new FileWriter("tttLogs.log", true)))){
            LocalDate localDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = localDate.format(formatter);
            pw.println(String.format("%s;%d;%s;%d;%d;%s", player1.getName(), p1Score, player2.getName(), p2Score, tieScore, formattedDate));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> readFile(){
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("tttLogs.log"))){

            String row = br.readLine();
            while (row != null){
                String[] values = row.split(";");
                if (Integer.parseInt(values[1]) != Integer.parseInt(values[3])) {
                    if (Integer.parseInt(values[1]) > Integer.parseInt(values[3])) {
                        data.add(values[0] + ": " + ((Integer.parseInt(values[1]) * 2) + Integer.parseInt(values[4])) + " points - " + values[5]);
                    }else{
                        data.add(values[2] + ": " + ((Integer.parseInt(values[3]) * 2) + Integer.parseInt(values[4])) + " points - " + values[5]);
                    }
                }
                row = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(data, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int num1 = Integer.parseInt(s1.substring(s1.indexOf(": ") + 2, s1.indexOf(" points")));
                int num2 = Integer.parseInt(s2.substring(s2.indexOf(": ") + 2, s2.indexOf(" points")));
                return Integer.compare(num2, num1);
            }
        });
        return data;
    }
}

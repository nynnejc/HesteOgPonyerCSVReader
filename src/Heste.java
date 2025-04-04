import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// Eksempel med BufferedReader

public class Heste {
    public static void main(String[] args) {
        String csvFile = "/Users/nyjc/IdeaProjects/22-Filer II/HesteCSV/heste.csv";
        String line;
        String longestName = "";
        String horseAge = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Spring headeren over
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 1) continue;
                String name = parts[0];
                if (name.length() > longestName.length()) {
                    longestName = name;
                    if (parts.length > 1) {
                        horseAge = parts[1];
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Kan ikke finde filen :(");
        }

        System.out.println("Hesten med det længste navn er: "
                + longestName + " og den er " + horseAge + " år gammel.");
    }
}

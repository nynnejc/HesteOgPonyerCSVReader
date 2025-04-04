import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
// Eksempel med tokenReader

public class Ponyer {
    public static void main(String[] args) {
        String csvFile = "/Users/nyjc/IdeaProjects/22-Filer II/HesteCSV/heste.csv";
        String longestName = "";
        String ponyAge = "";

        try (Scanner scanner = new Scanner(new FileReader(csvFile))) {
            // Spring headeren over
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try (Scanner tokenReader = new Scanner(line)) {
                    tokenReader.useDelimiter(",");
                    String name = tokenReader.hasNext() ? tokenReader.next() : "";
                    String age = tokenReader.hasNext() ? tokenReader.next() : "";
                    if (name.length() > longestName.length()) {
                        longestName = name;
                        ponyAge = age;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("kan ikke finde filen");
        }

        System.out.println("Hesten med det længste navn er: "
                + longestName + " og den er " + ponyAge + " år gammel.");
    }
}

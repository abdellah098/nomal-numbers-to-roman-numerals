import convertion.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean convertNewNumber = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("----- Programme de Conversion de Nombre Numérique en Nombre Romain -----");

        do {
            System.out.println("Saisir un nombre positif à convertir");

            try {

                int numberToConvert = sc.nextInt();
                if (numberToConvert <= 0 || numberToConvert > 3000) {
                    throw new Exception();
                } else {
                    System.out.println("Nombre numérique: " + numberToConvert);
                    System.out.println("Nombre romain: " + NumericNumberConverter.convertToRomanNumeral(numberToConvert));
                    convertNewNumber = repeatConvertion();
                }

            } catch (Exception ex) {
                sc.nextLine();
                System.out.println("La saisie est invalide: Entrez un nombre entre 1 et 3000");
            }

        } while (convertNewNumber);
    }

    private static boolean repeatConvertion() {
        Scanner sc = new Scanner(System.in);
        int response;

        while (true) {
            System.out.println("Voulez-Vous convertir un nouveau nombre? oui: 1  non: 0");
            try {
                response = sc.nextInt();
                if (response < 0 || response > 1) {
                    throw  new Exception();
                }
                break;
            } catch (Exception ex) {
                sc.nextLine();
                System.out.println("Réponse invalide");
            }
        }

        return response > 0;
    }
}

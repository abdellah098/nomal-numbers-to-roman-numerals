package convertion;

import java.util.ArrayList;
import java.util.List;

public class NumericNumberConverter {
    private static  final String UNIT = "UNIT"; // unité
    private static  final String TENS = "TENS"; // dixaine
    private static  final String HUNDRED = "HUNDRED"; // centaine
    private static  final String THOUSAND = "THOUSAND"; // milier

    // convertit un nombre numérique normal en nombre romain
    public static String convertToRomanNumeral(int numericNumber) throws Exception {
        StringBuilder romanNumber = new StringBuilder();

        if (numericNumber <= 0 || numericNumber > 3000) {
            throw new Exception();
        }

        while (numericNumber > 0) {

            if (numericNumber / 1000 >= 1) {
                romanNumber.append(convertNumberWithType(numericNumber / 1000, THOUSAND));
                numericNumber = numericNumber % 1000;

            } else if (numericNumber / 100 >= 1) {
                romanNumber.append(convertNumberWithType(numericNumber / 100, HUNDRED));
                numericNumber = numericNumber % 100;

            } else if (numericNumber / 10 >= 1) {
                romanNumber.append(convertNumberWithType(numericNumber / 10, TENS));
                numericNumber = numericNumber % 10;

            } else {
                romanNumber.append(convertNumberWithType(numericNumber , UNIT));
                numericNumber = 0;
            }
        }

        return romanNumber.toString();
    }

    /*
        convertit l' entrée (nombre, type) en nombre romain
        nombre: chifrre entre 1 et 9
        type: unité, dixaine, centaine, milier
        ex: pour l' entrée (5,100) le nombre à convertir est 500
     */
    private static  String convertNumberWithType(int number, String type) {
        String result = "";
        List<String> baseSymbols = getBaseSymbols(type);

        switch (number) {
            case 1:
            case 2:
            case 3:
                result += repeatSymbol(baseSymbols.get(0), number);
                break;
            case 4:
                result += baseSymbols.get(0) + baseSymbols.get(1);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                result += baseSymbols.get(1) + repeatSymbol(baseSymbols.get(0), number -5);
                break;
            case 9:
                result += baseSymbols.get(0) + baseSymbols.get(2);
                break;
        }

        return result;
    }

    // fonction utilitaire
    private static String repeatSymbol(String symbol, int numberOfRep) {
        StringBuilder sb = new StringBuilder();

        for (int count = 1; count <= numberOfRep; count++) {
            sb.append(symbol);
        }

        return sb.toString();
    }

    /*
         retourne la liste des nombres romain de base selon que le type du nombre numérique
         soit une unité, une dixaine, une centaine, ou milier
     */
    private static List<String> getBaseSymbols(String numberType) {
            List<String> baseSymbols = new ArrayList<>();

            switch (numberType) {
                case UNIT:
                    baseSymbols.add("I");
                    baseSymbols.add("V");
                    baseSymbols.add("X");
                    break;

                case TENS:
                    baseSymbols.add("X");
                    baseSymbols.add("L");
                    baseSymbols.add("C");
                    break;

                case HUNDRED:
                    baseSymbols.add("C");
                    baseSymbols.add("D");
                    baseSymbols.add("M");
                    break;

                case THOUSAND:
                    baseSymbols.add("M");
                    break;
            }

            return  baseSymbols;
    }
}

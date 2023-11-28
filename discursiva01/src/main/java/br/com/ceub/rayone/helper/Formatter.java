package br.com.ceub.rayone.helper;

public class Formatter {

    public static String addSpaces(int q) {
        StringBuilder spaces = new StringBuilder();

        for (int i = 0; i < q; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }
}

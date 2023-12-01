package br.com.ceub.rayone.sistematizacao.domain.helpers;

import java.util.Random;

public class GeneratePackTrackingCode {

    public static final String ALPHAS = "ABCDEFGHIJQLMNOPQRSTUVWXYZ";
    public static final String NUMERICS = "0123456789";

    public Random random = new Random();

    public String generate() {
        StringBuilder trackCode = new StringBuilder();

        trackCode.append(randomAlphas()).append(randomAlphas());

        int i = 0;
        while (i < 8) {
            trackCode.append(randomNumerics());

            i++;
        }

        trackCode.append("BR");

        return trackCode.toString();

    }

    private char randomAlphas() {

        return ALPHAS.charAt(random.nextInt(ALPHAS.length()));
    }

    private char randomNumerics() {

        return NUMERICS.charAt(random.nextInt(NUMERICS.length()));
    }
}

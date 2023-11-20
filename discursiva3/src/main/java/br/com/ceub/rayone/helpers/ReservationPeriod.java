package br.com.ceub.rayone.helpers;

import java.time.LocalDate;

public class ReservationPeriod {
    public LocalDate initial;
    public LocalDate end;

    public ReservationPeriod(LocalDate initial, LocalDate end) {
        this.initial = initial;
        this.end = end;
    }
}
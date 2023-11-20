package br.com.ceub.rayone;

import java.time.LocalDate;

import br.com.ceub.rayone.helpers.IntervalTree;
import br.com.ceub.rayone.helpers.ReservationPeriod;
import br.com.ceub.rayone.helpers.Reserve;

public class Main {
    public static void main(String[] args) {

        IntervalTree intervalTree = new IntervalTree();

        intervalTree
                .insert(
                        new Reserve(
                                1,
                                new ReservationPeriod(
                                        LocalDate.of(2023, 11, 19),
                                        LocalDate.of(2023, 11, 21))));

        Reserve newReserve = new Reserve(
                2,
                new ReservationPeriod(
                        LocalDate.of(2023, 11, 22),
                        LocalDate.of(2023, 11, 23)));

        boolean isAvaliable = intervalTree.isAvaliable(newReserve);

        if (isAvaliable) {
            System.out.println("A sala está disponível para reserva.");
        } else {
            System.out.println("A sala já está reservada para esse período");
        }
    }
}
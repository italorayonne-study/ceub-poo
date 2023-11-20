package br.com.ceub.rayone.helpers;

import java.time.LocalDate;

public class IntervalTreeNode {
    Reserve reserve;

    LocalDate maxEnd;
    IntervalTreeNode left;
    IntervalTreeNode right;

    public IntervalTreeNode(Reserve reserve) {
        this.reserve = reserve;
        this.maxEnd = reserve.period.end;
        this.left = null;
        this.right = null;
    }
}

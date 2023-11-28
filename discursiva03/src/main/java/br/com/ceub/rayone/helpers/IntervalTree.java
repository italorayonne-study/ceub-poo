package br.com.ceub.rayone.helpers;

import java.time.LocalDate;

public class IntervalTree {
    IntervalTreeNode root;

    public IntervalTree() {
        this.root = null;
    }

    public void insert(Reserve reserve) {
        root = insertInterval(root, reserve);
    }

    public boolean isAvaliable(Reserve reserve) {
        return checkAvailability(root, reserve);
    }

    private boolean checkAvailability(IntervalTreeNode node, Reserve reserve) {
        if (node == null) {
            return true;
        }

        if (node.reserve.period.end.isBefore(reserve.period.initial)) {
            return checkAvailability(node.right, reserve);
        } else if (node.reserve.period.initial.isAfter(reserve.period.end)) {
            return checkAvailability(node.left, reserve);
        } else {
            return false;
        }
    }

    private IntervalTreeNode insertInterval(IntervalTreeNode node, Reserve reserve) {
        if (node == null) {
            return new IntervalTreeNode(reserve);
        }

        LocalDate start = reserve.period.initial;

        if (start.isBefore(start)) {
            node.left = insertInterval(node.left, reserve);
        } else {
            node.right = insertInterval(node.right, reserve);
        }

        if (node.maxEnd.isBefore(reserve.period.end)) {
            node.maxEnd = reserve.period.end;
        }

        return node;
    }
}

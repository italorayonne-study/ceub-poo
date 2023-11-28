package br.com.ceub.rayone.discursiva03.utils;

import java.util.Stack;

public class Historic {
    Stack<Page> historicStack = new Stack<>();

    public void next(Page page) {
        historicStack.push(page);

        page.show();

    }

    public void previous() {
        if (!historicStack.isEmpty()) {
            historicStack.pop();

            if (!historicStack.isEmpty()) {
                historicStack.peek().show();
            } else {
                System.out.println("Página inicial");
            }
        } else {
            System.out.println("Histórico de navegação vazio");
        }
    }
}

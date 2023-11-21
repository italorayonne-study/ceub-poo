package br.com.ceub.rayone.discursiva03.utils;

public class Page {
    public String name;
    public Integer number;

    public Page(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public void show() {
        System.out.println("Visualizando a página: " + number + ". - " + name);
    }

}

package com.company;

public class Main {

    public static void main(String[] args) {
        Document cv = new Document("Życiorys Jana z Lublina");
        cv.setPhoto("IMG23456");
        cv.addSection("Wykształcenie")
                .addParagraph("2017 Podstawówka")
                .addParagraph("2018 Gimnazjum")
                .addParagraph("2019 Liceum");
        cv.addSection("Umiejętności")
                .addParagraph("praca zdalna")
                .addParagraph("granie")
                .addParagraph("śpiewanie")
                .addParagraph("szachy")
                .addParagraph(new ParagraphWithList().setContent("Technologie")
                        .addListItem("C")
                        .addListItem("C++")
                        .addListItem("Java"));

        cv.writeHTML(System.out);
    }
}

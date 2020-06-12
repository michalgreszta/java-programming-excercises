package com.company;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Section {
    String title;
    List<Paragraph> paragraphs = new ArrayList<>();

    public Section(String _title){
        this.title = _title;
    }

    public Section setTitle(String _title){
        this.title = _title;
        return this;
    }

    public Section addParagraph(String paragraphText){
        this.paragraphs.add(new Paragraph(paragraphText));
        return this;
    }

    public Section addParagraph(Paragraph p){
        this.paragraphs.add(p);
        return this;
    }

    public void writeHTML(PrintStream out) {
        out.printf("<section>%n");
        out.printf("<h2>%s</h2>%n", title);
        paragraphs.forEach(paragraph -> paragraph.writeHTML(out));
        out.printf("</section>%n");
    }
}

package com.company;

import java.io.PrintStream;

public class Paragraph {
    String content;

    Paragraph(){}

    Paragraph(String _content){
        this.content = _content;
    }

    public Paragraph setContent(String newContent){
        this.content = newContent;
        return this;
    }

    public void writeHTML(PrintStream out)
    {
        out.printf("<p>%s</p>%n", content);
    }
}

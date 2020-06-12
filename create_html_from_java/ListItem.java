package com.company;

import java.io.PrintStream;

public class ListItem {
    String content;

    ListItem(String _content){
        this.content = _content;
    }

    public void writeHTML(PrintStream out){
        out.printf("<li>%s</li>%n", content);
    }
}

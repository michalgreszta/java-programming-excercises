package com.company;

import java.io.PrintStream;

public class Photo {
    String url;

    Photo(String _url) {
        this.url = _url;
    }

    public void writeHTML(PrintStream out) {
        out.printf("<img src=\"%s\" alt=\"Smiley face\" height=\"42\" width=\"42\"/>\n", url);
    }
}
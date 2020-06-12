package com.company;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Document {
    String title;
    Photo photo;
    List<Section> sections = new ArrayList<>();

    Document(String _title) {
        this.title = _title;
    }

    public Document setTitle(String _title){
        this.title = _title;
        return this;
    }

    public Document setPhoto(String _photoUrl){
        this.photo = new Photo(_photoUrl);
        return this;
    }

    public Section addSection(String _sectionTitle){
        Section section = new Section(_sectionTitle);
        sections.add(section);
        return section;
    }

    public Document addSection(Section s){
        sections.add(s);
        return this;
    }

    public void writeHTML(PrintStream out) {
        out.printf("<html>%n");
        out.printf("<head>%n");
        out.printf("<title>%s</title>%n", title);
        out.printf("<meta charset=\"UTF-8\">%n");
        out.printf("</head>%n");
        out.printf("<body>%n");
        out.printf("<h1>%s</h1>%n", title);
        photo.writeHTML(out);
        sections.forEach(section -> section.writeHTML(out));
        out.printf("</body>%n");
        out.printf("</html>%n");
    }
}

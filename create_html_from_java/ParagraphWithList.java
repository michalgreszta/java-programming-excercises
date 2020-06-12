package com.company;

import java.io.PrintStream;

public class ParagraphWithList extends Paragraph {
    public UnorderedList list;

    ParagraphWithList(){
        super();
        this.list = new UnorderedList();
    }

    ParagraphWithList(String _content) {
        super(_content);
        this.list = new UnorderedList();
    }

    ParagraphWithList(String _content, UnorderedList _list){
        super(_content);
        this.list = _list;
    }

    public ParagraphWithList setContent(String _content){
        super.setContent(_content);
        return this;
    }

    public ParagraphWithList addListItem(String _content){
        list.addItem(_content);
        return this;
    }

    public void writeHTML(PrintStream out){
        super.writeHTML(System.out);
        list.writeHTML(System.out);
    }
}

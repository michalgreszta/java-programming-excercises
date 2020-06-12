package com.company;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UnorderedList {
   public List<ListItem> listItems;

   public UnorderedList(){
      this.listItems = new ArrayList<>();
   }

   public UnorderedList addItem(String _content){
      listItems.add(new ListItem(_content));
      return this;
   }

   public UnorderedList addItem(ListItem _item){
      listItems.add(_item);
      return this;
   }

   public void writeHTML(PrintStream out){
         out.printf("<ul>%n");
         listItems.forEach(listItem -> listItem.writeHTML(out));
         out.printf("</ul>%n");
   }
}

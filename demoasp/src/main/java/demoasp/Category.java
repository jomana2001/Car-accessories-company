package demoasp;

import java.util.List;
import java.util.ArrayList;

public class Category {
 protected String name ;
protected List<Product>products=new ArrayList<>();
 public Category(String name){
     this.name=name;
 }
}


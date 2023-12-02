package system;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int categoryId;
    private String name;
    private String description;
    private List<Category> categoryList = new ArrayList<Category>();
    public Category(int categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }
}
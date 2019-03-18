package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;

import java.util.ArrayList;
import java.util.List;

public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    @Override
    public String toString() {

        List<Item> returnItemList = new ArrayList<>();
        ItemParser itemParser = new ItemParser();
        returnItemList = itemParser.parseItemList(originalFileText);
        for(Item t: returnItemList){
            System.out.println(t.toString());
        }

        return null;
    }
}

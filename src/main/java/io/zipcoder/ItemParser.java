package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) {
        List<Item> itemList = new ArrayList<>();
        String[] splitString = valueToParse.split("##");
        for (int i = 0; i < splitString.length; i++) {
            try {
                Item myItem = parseSingleItem(splitString[i]);
                if(myItem!=null)
                itemList.add(myItem);
            }
            catch(ItemParseException e){

            }
        }
        return itemList;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        singleItem = singleItem.replaceAll("[\\^@%*]",":");

        String patternString = ("(\\w+):(\\w+);(\\w+):(\\d+\\.\\d+);(\\w+):(\\w+);(\\w+):(\\d{1,2}\\/\\d{1,2}\\/\\d{4})");


        Pattern pattern =Pattern.compile(patternString);
        Matcher match = pattern.matcher(singleItem);
        String name="";
        Double price=0.0d;
        String type="";
        String expiration="";
        Item returnItem=null;
        if(match.find()){
            name= String.valueOf(match.group(2));
            price= Double.valueOf(match.group(4));
            type= match.group(6);
            expiration=match.group(8);

            returnItem = new Item(name.toLowerCase(),price,type.toLowerCase(),expiration);
        }
        else
            throw new ItemParseException();

        //Item returnItem = new Item(name.toLowerCase(),price,type.toLowerCase(),expiration);
        System.out.println(returnItem);

        return returnItem;
    }
}

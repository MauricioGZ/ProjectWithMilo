package com.pages;

import org.openqa.selenium.By;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ItemPoll {
    private Map<String,By> ItemMap = new HashMap<String,By>();
    public ItemPoll() {

    }
    public By getItemXpath(String _key) {
        return this.ItemMap.get(_key);
    }
    public void addItem(String _key, By _value) {
        this.ItemMap.put(_key,_value);
    }
}

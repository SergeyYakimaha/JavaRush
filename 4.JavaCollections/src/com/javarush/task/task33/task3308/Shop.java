package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "Shop")
@XmlRootElement
public class Shop {
    @XmlElement(name = "goods")
    public Goods goods;
    @XmlElement(name = "count")
    public int count;
    @XmlElement(name = "profit")
    public double profit;
    @XmlElement(name = "secretData")
    public String[] secretData = new String[5];

    @XmlType(name = "Goods")
    public static class Goods {
        @XmlElement(name = "names")
        List<String> names = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("goods (" + goods.names.size() + "):\n");
        for (String str : goods.names) {
            sb.append(" - " + str + "\n");
        }
        sb.append("count: " + count + "\n");
        sb.append("profit: " + profit + "\n");
        sb.append("secretData (" + secretData.length + "):\n");
        for (String str : secretData) {
            sb.append(" - " + str + "\n");
        }
        return sb.toString();
    }
}


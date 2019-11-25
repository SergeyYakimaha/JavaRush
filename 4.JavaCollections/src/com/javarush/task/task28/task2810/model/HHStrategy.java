package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    public static void getStringFormat() {
        System.out.println(String.format(URL_FORMAT, "Kiev", 3));
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) throws IOException {
        Document document = Jsoup.connect(String.format(URL_FORMAT, "Kiev", 0))
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36")
                .referrer("no-referrer-when-downgrade")
                .get();
//        Elements vacancyList = document.getElementsByClass("vacancy-short__name");
//        for(Element vacancy : vacancyList) {
//            String key = vacancy.attr("data-qa");
//            String value = vacancy.attr("vacancy-name");
//            //Elements element = vacancy.getElementsByAttribute("vacancy-name");
//            Elements element1 = vacancy.getElementsByClass("vacancy-short__name");
//        }

        System.out.println(document.html());
        return Collections.emptyList();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    //private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data.html";


    public static void getStringFormat() {
        System.out.println(String.format(URL_FORMAT, "Kiev", 3));
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        Document document = Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36")
                .referrer("no-referrer-when-downgrade")
                .get();
//      Document document = Jsoup.connect("http://javarush.ru/testdata/big28data.html")
//                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36")
//                .referrer("no-referrer-when-downgrade")
//                .get();
        return document;
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) throws IOException {
        List<Vacancy> vacancies = new ArrayList<>();

        for (int i = 0; ; i++) {
            Document document = getDocument(searchString, i);
            Elements vacancyList = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            if (vacancyList.size() == 0)
                break;
            vacancyList.forEach(vacancy -> {
                String city = vacancy.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").get(0).text();
                String title = vacancy.getElementsByAttributeValue("target", "_blank").get(0).text();
                String companyName = vacancy.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").get(0).text();

                Elements salaryElement = vacancy.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation");
                String salary = "";
                if (salaryElement.size() != 0)
                    salary = salaryElement.get(0).text();

                Elements elementsURL = vacancy.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title");
                String url = elementsURL.attr("href");

                Vacancy newVacancy = new Vacancy();
                newVacancy.setCity(city);
                newVacancy.setTitle(title);
                newVacancy.setCompanyName(companyName);
                newVacancy.setUrl(url);
                newVacancy.setSalary(salary);
                newVacancy.setSiteName(URL_FORMAT);

                vacancies.add(newVacancy);
                //System.out.println(newVacancy.toString());
            });
        }
        return vacancies;
    }

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
}

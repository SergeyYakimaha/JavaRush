package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        DataAdapter dataAdapter = new DataAdapter(new CustomerClass("JavaRush Ltd.", "Ukraine"),
                new ContactClass("Ivanov, Ivan", "+38(050)123-45-67"));
        System.out.println(dataAdapter.getCompany());
        System.out.println(dataAdapter.getCountryCode());
        System.out.println(dataAdapter.getDialString());
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getContactLastName());
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            for (Map.Entry<String, String> entry : countries.entrySet()) {
                if (entry.getValue().equals(customer.getCountryName()))
                    return entry.getKey();
            }
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().split(", ")[1];
        }

        @Override
        public String getContactLastName() {
            return contact.getName().split(", ")[0];
        }

        @Override
        public String getDialString() {
            return "callto://+" + contact.getPhoneNumber().replaceAll("[^0-9]", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }

    public static class CustomerClass implements Customer {
        private String companyName;
        private String countryName;

        public CustomerClass(String companyName, String countryName) {
            this.companyName = companyName;
            this.countryName = countryName;
        }

        @Override
        public String getCompanyName() {
            return companyName;
        }

        @Override
        public String getCountryName() {
            return countryName;
        }
    }

    public static class ContactClass implements Contact {
        private String name;
        private String phoneNumber;

        public ContactClass(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getPhoneNumber() {
            return phoneNumber;
        }
    }
}
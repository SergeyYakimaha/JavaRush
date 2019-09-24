package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy HH:mm:ss:S", Locale.ENGLISH);

    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("your_file_name", null);
            File yourFile = new File("c:\\1.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();

            User user1 = new User();
            user1.setFirstName("Сергей");
            user1.setLastName("Якимаха");
            user1.setBirthDate(new Date());
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user1);

            User user2 = new User();
            user2.setFirstName("Лена");
            user2.setLastName("Сидорова");
            user2.setBirthDate(new Date());
            user2.setMale(false);
            user2.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

//            System.out.println(javaRush.equals(loadedObject));
//            System.out.println(javaRush.hashCode());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            if (users.size() != 0){
                for(User user: users){
                    bufferedWriter.write(user.getFirstName());
                    bufferedWriter.newLine();
                    bufferedWriter.write(user.getLastName());
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(user.getBirthDate().getTime()));
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(user.isMale()));
                    bufferedWriter.newLine();
                    bufferedWriter.write(user.getCountry().toString());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (bufferedReader.ready()){
                User user = new User();
                user.setFirstName(bufferedReader.readLine());
                user.setLastName(bufferedReader.readLine());
                user.setBirthDate(new Date(Long.parseLong(bufferedReader.readLine())));
                user.setMale(Boolean.parseBoolean(bufferedReader.readLine()));
                user.setCountry(User.Country.valueOf(bufferedReader.readLine()));
                users.add(user);
            }
            bufferedReader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

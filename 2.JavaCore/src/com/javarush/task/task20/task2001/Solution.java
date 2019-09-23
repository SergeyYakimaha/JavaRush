package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.*;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = new File("c:\\1\\1.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            //Human ivanov = new Human();
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();

            System.out.println(ivanov.equals(somePerson));
            System.out.println(somePerson.name);
            for (Asset a : somePerson.assets) {
                System.out.println(a);
            }

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //BufferedWriter reader = new BufferedWriter(new OutputStreamWriter(outputStream)) ;
            PrintWriter pw = new PrintWriter(outputStream);
            pw.println(this.name);
            if (assets.size() > 0) {
                for (Asset asset : assets) {
                    pw.println(asset.getName());
                    pw.println(asset.getPrice());
                }
            }
            pw.flush();
            pw.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            this.name = br.readLine();
            ArrayList<Asset> assets1 = new ArrayList<>();
            while (br.ready()) {
                Asset asset = new Asset(br.readLine(), Double.parseDouble(br.readLine()));
                this.assets.add(asset);
            }
            br.close();
        }
    }
}

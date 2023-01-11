import javax.swing.plaf.IconUIResource;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Connection1 connection1 = new Connection1();

           /*
         create table "it-academy".countries (
         id int primary key not null unique,
         name varchar(255) not null unique,
         code varchar(255) not null unique,
         population int not null,
         president_name varchar(255)
         );
         create table "it-academy".cities (
         id int primary key not null unique,
         name varchar(255) not null,
         country_id int references "it-academy".countries(id),
         maior_name varchar(255),
         population int
         );
         create table "it-academy".people (
         id int primary key not null unique,
         fio varchar(1000) not null,
         birth_day timestamp not null,
         city_id int references "it-academy".cities(id) );
         */

         City city = new City();
         Countries countries = new Countries();
         People people=new People();

         System.out.println("Введите название страны !");
         String enterCountyName=scan.next();
         countries.setName(enterCountyName);
         System.out.println("Введите код страны");
         int enterCountryCode=scan.nextInt();
         countries.setCode(enterCountryCode);
         System.out.println("Введите численность населения");
         int enterCountryPopulation=scan.nextInt();
         countries.setPopulation(enterCountryPopulation);
         System.out.println("Введите президента страны");
         String enterCountryPresidentName=scan.next();
         countries.setPresident(enterCountryPresidentName);
         connection1.insertCountry(countries);
         connection1.selectCountry(countries);

         System.out.println("ВВедите наименование города ");
         String enterCityName = scan.next();
         city.setName(enterCityName);
         System.out.println("Введитн id страны");
         int enetCityCountryId = scan.nextInt();
         city.setCountry_id(enetCityCountryId);
         System.out.println("Введите руководителя города");
         String enterCityMayorName = scan.next();
         city.setFioMayor(enterCityMayorName);
         System.out.println("Введите численность населения");
         int enterCityPopulation = scan.nextInt();
         city.setPopulation(enterCityPopulation);
         connection1.insertCities(city );

         connection1.selectCity(city);

          System.out.println("ВВедите наименование города ");
          String enterupdCityName = scan.nextLine();
          city.setName(enterupdCityName);
          System.out.println("Введитн id страны");
          int enetupdCityCountryId = scan.nextInt();
          city.setCountry_id(enetupdCityCountryId);
          System.out.println("Введите руководителя города");
          String enterupdCityMayorName = scan.nextLine();
          city.setFioMayor(enterupdCityMayorName);
          System.out.println("Введите численность населения");
          int enterupdCityPopulation = scan.nextInt();
          city.setPopulation(enterupdCityPopulation);
          System.out.println("Введите id города");
          int entIdOfCity=scan.nextInt();
          city.setId(entIdOfCity);
          connection1.updateCity(city);//

          System.out.println("Введите ФИО");
          String enterPeopleFio=scan.next();
          people.setFio(enterPeopleFio);
          System.out.println("Введите дату рождения");
          int enterPeopleBirthDay=scan.nextInt();
          people.setBirthDate(new Date(enterPeopleBirthDay));
          System.out.println("Введите id города");
          int enterPeopleCityId=scan.nextInt();
          people.setCity_id(enterPeopleCityId);
          connection1.insertPeople(people);

          System.out.println("Выберите id города ,который хотите удалить ");
          int enterDeleteCityById=scan.nextInt();
          city.setId(enterDeleteCityById);
          connection1.deleteCityById(city);

          System.out.println("Выберите id человека ,которого хотите удалить ");
          int enterDeletePeopleById=scan.nextInt();
          people.setId(enterDeletePeopleById);
          connection1.deletePeopleById(people);
    }
}

package peaksoft;

import peaksoft.entity.Address;
import peaksoft.entity.Country;
import peaksoft.entity.Programmer;
import peaksoft.entity.Project;
import peaksoft.enums.Countries;
import peaksoft.enums.Status;
import peaksoft.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        AddressService addressService = new AddressServiceImpl();
        Address address1 = new Address("Bishkek", "Lev Tolstoi", 61);
        Address address2 = new Address("Osh", "Osmonov", 23);
        List<Address> addresses = new ArrayList<>(List.of(address1, address2));
        Country country1 = new Country(Countries.TURKEY, "Country");
        Country country2 = new Country(Countries.KYRGYZSTAN, "Country1");
        List<Country>countries = List.of(country2,country1);

        Programmer programmer1 = new Programmer("Eliza ", "Ashyrbaeva", LocalDate.of(2004, 1, 30), Status.COLLABORATOR);
        Programmer programmer2 = new Programmer("Nuriza ", "Muratova", LocalDate.of(2004, 2, 5), Status.CONTRIBUTE);
        Programmer programmer3 = new Programmer("Zhiydegul ", "Jalilova", LocalDate.of(1993, 1, 17), Status.OWNER);
List<Programmer>programmers = List.of(programmer1,programmer2,programmer3);
        Project project1 = new Project("Peaksoft", "IdCompany", LocalDate.of(2022, 01, 01), LocalDate.of(2022, 7, 12), 600000);
        Project project2 = new Project("Taxi", "Project", LocalDate.of(2020, 5, 15), LocalDate.of(2022, 12, 30), 4000000);
        List<Project>projects = List.of(project1,project2);
        CountryService countryService = new CountryServiceImpl();
        ProjectService projectService = new ProjectServiceImpl();
        ProgrammerService programmerService = new ProgrammerServiceImpl();
        while (true) {
            System.out.println("""
                    >>>>>>>>>>ADDRESS<<<<<<<<<<
                    1.Save Address->
                    2.Save All Address->
                    3.Get All->
                    4.Find By Id->
                    5.Delete All->
                    6.Update Address->
                                         
                    *****************************
                                         
                    >>>>>>>>>>COUNTRY<<<<<<<<<
                    7. Save Country->
                    8. Save All Countries->
                    9. Get All->
                    10.Find By Id->
                    11. Delete By Id->
                    12.Delete All->
                    13.Update->
                    14.Get Long Description->
                    15.Find By Name->
                    16.Count The Country->
                                         
                    ******************************
                                         
                    >>>>>>>>>>Programmer<<<<<<<<<<
                    17.Add Constraint Unique->
                    18.Save ->
                    19.Save All->
                    20.Get All()->
                    21.Find By Id->
                    22.Delete By Id->
                    23.Delete All->
                    24.Update->
                    25.Find By Country Name->
                    26.Find Youngest->
                    27.Find Eldest();
                                         
                    ******************************
                                         
                    >>>>>>>>>>>Project<<<<<<<<<<<<
                    28.Save->
                    29.Save All->
                    30.Find By Id->
                    31.Delete By Id->
                    32.Delete All->
                    33.Update->
                    34.Assign->
                    35.Find Expensive->
                    36.Find Short Time Project->
                    """);
            int num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1 -> System.out.println(addressService.save(address1, 1L));
                case 2 -> System.out.println(addressService.saveAll(addresses, 4L));
                case 3 -> System.out.println(addressService.getAll());
                case 4 -> System.out.println(addressService.findById(new Scanner(System.in).nextLong()));
                case 5 -> System.out.println(addressService.deleteAll());
                case 6 -> System.out.println(addressService.update(address2, new Scanner(System.in).nextLong()));
                case 7 -> System.out.println(countryService.saveCountry(country1));
                case 8-> System.out.println(countryService.saveAllCountries(countries));
                case 9-> System.out.println(countryService.getAll());
                case 10-> System.out.println(countryService.findById(new Scanner(System.in).nextLong()));
                case 11-> System.out.println(countryService.deleteById(new Scanner(System.in).nextLong()));
                case 12-> System.out.println(countryService.deleteAll());
                case 13-> System.out.println(countryService.update(country1, 4L));
                case 14-> System.out.println(countryService.getLongDescription());
                case 15-> System.out.println(countryService.findByName(new Scanner(System.in).nextLine()));
                case 16-> System.out.println(countryService.countTheCountry());
                case 17-> System.out.println(programmerService.addConstraintUnique());
                case 18-> System.out.println(programmerService.save(programmer1));
                case 19-> System.out.println(programmerService.saveAll(programmers));
                case 20-> System.out.println(programmerService.getAll());
                case 21-> System.out.println(programmerService.findById(new Scanner(System.in).nextLong()));
                case 22-> System.out.println(programmerService.deleteById(new Scanner(System.in).nextLong()));
                case 23-> System.out.println(programmerService.deleteAll());
                case 24-> System.out.println(programmerService.update(programmer2, 4L));
                case 25-> System.out.println(programmerService.findByCountryName(new Scanner(System.in).nextLine()));
                case 26-> System.out.println(programmerService.findYoungest());
                case 27-> System.out.println(programmerService.findEldest());
                case 28-> System.out.println(projectService.save(project1));
                case 29-> System.out.println(projectService.saveAll(projects));
                case 30-> System.out.println(projectService.findById(new Scanner(System.in).nextLong()));
                case 31-> System.out.println(projectService.deleteById(new Scanner(System.in).nextLong()));
                case 32-> System.out.println(projectService.deleteAll());
                case 33-> System.out.println(projectService.update(project1, new Scanner(System.in).nextLong()));
                case 34-> System.out.println(projectService.assign(new Scanner(System.in).nextLong(), new Scanner(System.in).nextLong()));
                case 35-> System.out.println(projectService.findExpensive());
                case 36->projectService.findShortTimeProject();
            }

        }
    }
}

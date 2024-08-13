package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .phone("34343435556")
                .email("stark@gmail.com")
                .address("NY")
                .description("all fields")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("TonyReq")
                .lastName("Stark")
                .phone("3434347797")
                .email("stark123@gmail.com")
                .address("NY")
                .build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .phone("123")
                .email("wick@gmail.com")
                .address("NY")
                .description("John")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .phone("1238965125698745622322555")
                .email("wick1@gmail.com")
                .address("NY")
                .description("John")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .phone("wwwwwwwwwwww")
                .email("wick1@gmail.com")
                .address("NY")
                .description("John")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .phone("")
                .email("wick1@gmail.com")
                .address("NY")
                .description("John")
                .build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/contact.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line = reader.readLine();
        }

        return list.iterator();

    }
}




package com.batch.dataload.service;

import com.batch.dataload.entity.ArchivedCustomerEntity;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    public List<ArchivedCustomerEntity> getData() {
        Faker faker = new Faker();
        List<ArchivedCustomerEntity> listOfArchivedCustomerDetails = new ArrayList<>();
        for (int counter = 0; counter < 10000; counter++) {
            ArchivedCustomerEntity archivedCustomerDetail = new ArchivedCustomerEntity();
            archivedCustomerDetail.setFirstName(faker.name().firstName());
            archivedCustomerDetail.setLastName(faker.name().lastName());
            archivedCustomerDetail.setUserName(faker.name().username());
            archivedCustomerDetail.setMobile(faker.number().digits(10));
            listOfArchivedCustomerDetails.add(archivedCustomerDetail);
        }
        return listOfArchivedCustomerDetails;
    }
}

package com.batch.dataload.service;

import com.batch.dataload.entity.ArchivedCustomerEntity;
import com.batch.dataload.repository.ArchivedCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

@Service
public class ArchivedCustomerService {

    @Autowired
    private ArchivedCustomerRepository archivedCustomerRepository;

    @Autowired
    private TimeService timeService;

    @Autowired
    private DataService dataService;

    /**
     * 16 seconds with logging 10000 records
     */
    public void populateUsingJpa() {
        List<ArchivedCustomerEntity> listOfArchivedCustomers = dataService.getData();

        LocalDateTime start = LocalDateTime.now();
        archivedCustomerRepository.saveAll(listOfArchivedCustomers);
        LocalDateTime end = LocalDateTime.now();

        timeService.logTotalTimeTakenForExecution(start, end);
    }

    /**
     * 14 seconds with logging 10000 records
     * Using fork join pool of 6 threads 11 seconds 10000 recs
     */
    public void populateUsingJpaWithBatchConfigurations() {
        List<ArchivedCustomerEntity> listOfArchivedCustomers = dataService.getData();

        LocalDateTime start = LocalDateTime.now();

//        ForkJoinPool forkJoinPool = new ForkJoinPool(6);
//        SplitterService splitterService = new SplitterService(listOfArchivedCustomers, archivedCustomerRepository);
//        forkJoinPool.invoke(splitterService);

        int totalObjects = listOfArchivedCustomers.size();
        int batchSize = 1000;
//        for (int i = 0; i < totalObjects; i = i + batchSize) {
//            if( i+ batchSize > totalObjects){
//                List<ArchivedCustomerEntity> chunks = listOfArchivedCustomers.subList(i, totalObjects - 1);
//                archivedCustomerRepository.saveAll(chunks);
//                break;
//            }
//            List<ArchivedCustomerEntity> chunks = listOfArchivedCustomers.subList(i, i + batchSize);
//            archivedCustomerRepository.saveAll(chunks);
//        }

        LocalDateTime end = LocalDateTime.now();

        timeService.logTotalTimeTakenForExecution(start, end);
    }


}


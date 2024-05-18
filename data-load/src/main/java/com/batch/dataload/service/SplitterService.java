package com.batch.dataload.service;

import com.batch.dataload.entity.ArchivedCustomerEntity;
import com.batch.dataload.repository.ArchivedCustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


public class SplitterService extends RecursiveTask<Boolean> {
    private List<ArchivedCustomerEntity> list;
    private ArchivedCustomerRepository archivedCustomerRepository;

    public SplitterService(List<ArchivedCustomerEntity> list, ArchivedCustomerRepository archivedCustomerRepository) {
        this.archivedCustomerRepository = archivedCustomerRepository;
        this.list = list;
    }

    @Override
    protected Boolean compute() {
        int size = list.size();

        if (size <= 1000) {
            System.err.println("saving to db");
            archivedCustomerRepository.saveAll(list);
            return true;

        } else {
            int mid = size / 2;
            SplitterService leftSplit = new SplitterService(list.subList(0, mid), archivedCustomerRepository);
            SplitterService rightSplit = new SplitterService(list.subList(mid, size), archivedCustomerRepository);

            leftSplit.fork();
            rightSplit.compute();
            leftSplit.join();

            return true;
        }
    }


}

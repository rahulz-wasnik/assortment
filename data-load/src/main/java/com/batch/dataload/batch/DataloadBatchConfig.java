package com.batch.dataload.batch;

import com.batch.dataload.entity.ArchivedCustomerEntity;
import com.batch.dataload.repository.ArchivedCustomerRepository;
import com.batch.dataload.service.DataService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.orm.jpa.JpaTransactionManager;

//@Configuration
public class DataloadBatchConfig {

    @Autowired
    private ArchivedCustomerRepository archivedCustomerRepository;

    @Autowired
    private DataService dataService;

    @Bean
    public ListItemReader<ArchivedCustomerEntity> reader() {
        return new ListItemReader<>(dataService.getData());
    }

    @Bean
    public RepositoryItemWriter<ArchivedCustomerEntity> writer() {
        RepositoryItemWriter<ArchivedCustomerEntity> writer = new RepositoryItemWriter<>();
        writer.setRepository(archivedCustomerRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1(JobRepository jobRepository, JpaTransactionManager jpaTransactionManager, ItemReader<ArchivedCustomerEntity> reader,
                      ItemWriter<ArchivedCustomerEntity> writer, TaskExecutor taskExecutor) {
        return new StepBuilder("step1", jobRepository)
                .<ArchivedCustomerEntity, ArchivedCustomerEntity> chunk(1000, jpaTransactionManager)
                .reader(reader)
                .writer(writer)
                .taskExecutor(taskExecutor)
                .build();
    }

    @Bean
    public Job dataLoadJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("dataLoadJob", jobRepository)
                .start(step1)
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(6);
        return asyncTaskExecutor;
    }
}

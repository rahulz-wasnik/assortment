package com.batch.dataload;

import com.batch.dataload.entity.AccountEntity;
import com.batch.dataload.entity.JobDetailsEntity;
import com.batch.dataload.repository.AccountRepository;
import com.batch.dataload.repository.ArchivedCustomerRepository;
import com.batch.dataload.repository.JobDetailsRepository;
import com.batch.dataload.service.DataService;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class DataLoadApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(DataLoadApplication.class);

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private JobDetailsRepository jobDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(DataLoadApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		JobDetailsEntity jobDetailsEntity = new JobDetailsEntity();
		jobDetailsEntity.setJobStatus("Terminated");
		jobDetailsEntity.setName("Data load");
		jobDetailsRepository.save(jobDetailsEntity);
	}
}

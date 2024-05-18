package com.batch.dataload.batch;

import com.batch.dataload.entity.AccountEntity;
import com.batch.dataload.entity.JobDetailsEntity;
import com.batch.dataload.repository.AccountRepository;
import com.batch.dataload.repository.JobDetailsRepository;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class ScheduledJobs {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JobDetailsRepository jobDetailsRepository;

    @Scheduled(fixedRate = 10000)
    @SchedulerLock(name = "data_load", lockAtLeastFor = "PT5S", lockAtMostFor = "PT5S")
    public void scheduleTask_A() {
        triggerJob("A");
    }

    @Scheduled(fixedRate = 10000)
    @SchedulerLock(name = "data_load", lockAtLeastFor = "PT5S", lockAtMostFor = "PT5S")
    public void scheduleTask_B() {
        triggerJob("B");
    }

//    @Scheduled(fixedRate = 10000)
    public void scheduleTask_C() {
        triggerJob("C");
    }

//    @Scheduled(fixedRate = 5000)
    public void scheduleTask_D() {
        endJob("Terminator");
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    private void deductMoney(String taskName) {
        System.out.println(taskName+ " commencing");
        Optional<AccountEntity> accountEntity = accountRepository.findById(1L);
        if (accountEntity.isPresent()) {
            AccountEntity account = accountEntity.get();
            Integer balance = account.getBalance();
            account.setBalance(balance - 100);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            accountRepository.save(account);
            System.out.println(taskName+ " updated account balance "+ account.getBalance());
        }
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    private void getBalance(String taskName) {
        System.out.println(taskName+ " commencing");
        Optional<AccountEntity> accountEntity = accountRepository.findById(1L);
        if (accountEntity.isPresent()) {
            AccountEntity account = accountEntity.get();
            System.out.println(taskName + " Current balance is - "+ account.getBalance());
        }
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    private  void triggerJob(String taskName) {
        System.out.println(taskName + " commencing");
        Optional<JobDetailsEntity> jobDetailsEntity = jobDetailsRepository.findById(1L);
        if (jobDetailsEntity.isPresent()) {
            JobDetailsEntity savedJobDetails = jobDetailsEntity.get();
            System.out.println(taskName + " job status "+ savedJobDetails.getJobStatus());
            if (!savedJobDetails.getJobStatus().equalsIgnoreCase("Running")) {
                savedJobDetails.setJobStatus("Running");
                jobDetailsRepository.save(savedJobDetails);
                System.out.println(taskName + " updated job details");
            } else {
                System.out.println(taskName + " job is already running");
            }
        }
    }

    private  void endJob(String taskName) {
        System.out.println(taskName + " commencing");
        Optional<JobDetailsEntity> jobDetailsEntity = jobDetailsRepository.findById(1L);
        if (jobDetailsEntity.isPresent()) {
            JobDetailsEntity savedJobDetails = jobDetailsEntity.get();
            savedJobDetails.setJobStatus("Terminated");
            jobDetailsRepository.save(savedJobDetails);
            System.out.println("Job terminated");
        }
    }
}

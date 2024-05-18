package com.multithreaded.policycompliance;

import com.multithreaded.policycompliance.dto.ComplianceDto;
import com.multithreaded.policycompliance.service.ComplianceService;
import com.multithreaded.policycompliance.service.PolicyService;
import com.multithreaded.policycompliance.service.ReleaseService;
import com.multithreaded.policycompliance.service.RuleExecutionService;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@SpringBootApplication
public class PolicyComplianceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyComplianceApplication.class, args);

//		RuleExecutionService ruleExecutionService = new RuleExecutionService();
//		PolicyService policyService = new PolicyService(ruleExecutionService);
//		ReleaseService releaseService = new ReleaseService();
//		ComplianceService complianceService = new ComplianceService(releaseService, policyService);
//
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		ComplianceDto complianceDto = complianceService.getCompliancePerRelease("RN");
//
//		stopWatch.stop();
//		System.out.println(Thread.currentThread().getName() + stopWatch.lastTaskInfo().getTimeSeconds());
//
//
//		complianceDto.getPolicies().forEach(p -> System.out.println(p.getName()));
	}
}

@Data
@Builder
class Employee {
	private int id;
	private String name;
}

class MiddleNodeFinder {

	public static void main(String[] args) {
		Map<Integer,Employee> employees = new HashMap<>();
		for (int x = 1; x<=1000000; x++) {
			employees.put(x, Employee.builder().id(x).name("X").build());
		}
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		employees.get(1);
		stopWatch.stop();
		System.out.println(Thread.currentThread().getName() + stopWatch.lastTaskInfo().getTimeSeconds());
	}
}

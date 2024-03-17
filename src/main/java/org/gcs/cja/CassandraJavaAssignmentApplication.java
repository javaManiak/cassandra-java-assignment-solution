package org.gcs.cja;

import org.gcs.cja.controller.ScanBirdController;
import org.gcs.cja.controller.ScanLocationController;
import org.gcs.cja.service.ScanBirdService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.gcs.cja.cassandraconfig"})
@ComponentScan(basePackageClasses= {ScanLocationController.class, ScanBirdController.class,ScanBirdService.class})
public class CassandraJavaAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CassandraJavaAssignmentApplication.class, args);
	}

}

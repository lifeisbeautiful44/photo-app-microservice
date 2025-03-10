package lhng.learning.microservice.photoapp.account.PhotoApp_Api_Account_Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppApiAccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiAccountManagementApplication.class, args);
	}

}

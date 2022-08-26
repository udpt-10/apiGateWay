package com.udpt.apiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class ApiGatewayApplication {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/employee/all", "/employee/findByEmail","/employee/findByUserName",
								"/employee/addNewEmployee","/employee/editEmployee","/employee/deleteEmployee")
						.uri("http://localhost:8001")) // it's the service
				.route(p -> p
						.path("/OTRequest/all", "/OTRequest/add","/OTRequest/{employeeId}", "/OTRequest/managerId/{managerId}", "/OTRequest/edit", "/OTRequest/delete",
								"/LeaveRequest/all","/LeaveRequest/add","/LeaveRequest/{employeeId}", "/LeaveRequest/managerId/{managerId}", "/LeaveRequest/edit", "/LeaveRequest/delete",
								"/WorkFromHome/all", "/WorkFromHome/add", "/WorkFromHome/{employeeId}", "/WorkFromHome/edit","/WorkFromHome/delete",
								"/GeneralInfo/all", "/GeneralInfo/add", "/GeneralInfo/{generalInfoId}", "/GeneralInfo/edit", "/GeneralInfo/delete",
								"/SupportRequest/all", "/SupportRequest/allByEmployeeId/{employeeId}", "/SupportRequest/delete", "/SupportRequest/allByDepartment", "/SupportRequest/add", "/SupportRequest/edit", "/SupportRequest/managerId/{managerId}"
								)
						.uri("http://localhost:8002"))
				.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
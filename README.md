# Microservices Project

This is a microservices project consisting of multiple services - `employee`, `department`, `organization`, `api gateway`, `eureka server`, `eureka client`, and `spring cloud config server`.

## Technology Stack

- Docker Compose for running all microservices
- MySQL for database
- Adminer for administering databases inside containers at localhost:8080
- Spring Cloud Bus for updating changes using actuator/busrefresh endpoint
- RabbitMQ for message queue
- Spring Actuator for monitoring and managing applications
- OpenFeign for inter-service communication and making requests from `employee` service to `department` and `organization` services
- Circuit Pattern and Resilience4j for handling faults and failures in the microservices
- Swagger Documentation for `employee`, `department`, and `organization` services to view their endpoints.

## Service Overview

- **Employee Service:** Responsible for managing employees. Create an employee using this service.

- **Department Service:** Manages departments. Create a department through this service.

- **Organization Service:** Manages organizations. Create an organization using this service.

- **API Gateway:** Serves as an entry point to interact with microservices. Access the endpoint `http://localhost:9191/api/employees/1` to get employee details with ID 1. The response includes department and organization information, and it makes use of OpenFeign to call `department` and `organization` services and fetch data.
- Before accessing the API Gateway endpoint, you need to create an employee, an organization, and a department by making POST requests to the corresponding endpoints:

- Create an employee using the endpoint http://localhost:9191/api/employees in the employee service.
- Create an organization using the endpoint http://localhost:9191/api/organizations in the organization service.
- Create a department using the endpoint http://localhost:9191/api/departments in the department service.
- Once all the services are up and running, you can access the individual services and interact with them through the API Gateway.

## Usage

1. Start all microservices and related infrastructure using Docker Compose.

2. Access Adminer at `http://localhost:8080` to administer the databases inside containers.

3. Create an employee, department, and organization via the respective service endpoints.

4. Access the API Gateway endpoint `http://localhost:9191/api/employees/1` to retrieve employee information along with the corresponding department and organization data.

Example Response:

```json
{
    "employee": {
        "id": 1,
        "firstName": "Emily",
        "lastName": "Brown",
        "email": "emilybrown@example.com",
        "departmentCode": "IT001",
        "organizationCode": "ABC_ORG"
    },
    "department": {
        "id": 1,
        "departmentName": "IT",
        "departmentDescription": "Information Technology",
        "departmentCode": "IT001"
    },
    "organization": {
        "id": 1,
        "organizationName": "ABC",
        "organizationDescription": "ABC Organization Description",
        "organizationCode": "ABC_ORG",
        "createdDate": "2023-07-25T11:00:41.077738"
    }
}
```

## Running the Project

To run the entire project and start all microservices and their related infrastructure, follow these steps:

1. Make sure you have Docker installed on your system.

2. Open a terminal and navigate to the root folder of the project.

3. Run the following command to start the services:

```bash
docker-compose up
```

This command will launch all the microservices, databases, RabbitMQ, and other necessary components defined in the `docker-compose.yml` file.



## Note

Please ensure all the services are running and connected to the Eureka Server for successful communication between microservices. For more details, refer to the Swagger documentation of individual services.


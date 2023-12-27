# JavaAssignment
This is my Assignment which contains Entry Level Task completed
# Spring Boot Project with CouchDB Connectivity

## Prerequisites

Before running the project, ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- CouchDB (Make sure CouchDB server is running)

## Configuration

1. **CouchDB Configuration:**
   - Ensure your CouchDB server is up and running.
   - Update the CouchDB configuration in `src/main/resources/application.properties` with your CouchDB server details.

    ```properties
    # CouchDB Configuration
    couchdb.url=http://localhost:5984
    couchdb.username= (username)
    couchdb.password= (password)
    ```

2. **Build the Project:**
   - Open a terminal and navigate to the project directory.
   - Run the following Maven command to build the project:
     ```bash
     mvn clean install
     ```

## Running the Application

1. **Run the Spring Boot Application:**
   - Execute the following command to run the application:
     ```bash
     mvn spring-boot:run
     ```

2. **Access the API:**
   - Once the application is running, you can access the API at `http://localhost:8080/api`.

## API Endpoints

- **POST /api/save:** Save data to CouchDB.
  - Example Request:
    ```bash
    curl -X POST http://localhost:8080/api/save -H "Content-Type: application/json" -d '{"name": "Dhanshree Shimpi"}'
    ```

## Additional Information

- This project uses the `lightcouch` library for CouchDB connectivity. Ensure the library is correctly added to the project dependencies.
- I have used Lombok as well to avoid wrting boiler plate code
- Customize the project as needed for your specific use case.

Feel free to reach out for any issues or questions.


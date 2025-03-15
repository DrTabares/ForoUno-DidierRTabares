package foroUnoDidierRTabares;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class EjemploUnoForoDidier {
	
	// Definition of constants where employee data is written

    private static final String[] NAMES = {"Camilo", "Didier", "Diego", "Pablo", "Jorge", "Arturo", "Juan", "Lucas"};
    private static final String[] LAST_NAMES = {"Tabares", "Montoya", "Cano", "Berrío", "Torres", "Ríos"};
    private static final String[] DOCUMENT_TYPES = {"CC", "IT", "IC"};
    private static final String[] SECTION = {"Lathe Operator", "Mill Operator", "Conventional Operator"};

		// This code block generates a CSV file with pseudo-random worker information using the random library, 
		// filePath is the path of the CSV file, numWorkers is the number of workers to generate.

    public static void createWorkersCSV(String filePath, int numWorkers) {
        Random rand = new Random();

        try (FileWriter writer = new FileWriter(filePath)) {
        	
            // Write header of the information provided by each worker.
        	
            writer.write("Document_Type;Document_ID;Name;Last_Name;Section;Salary\n");

            for (int i = 0; i < numWorkers; i++) {
                String documentType = DOCUMENT_TYPES[rand.nextInt(DOCUMENT_TYPES.length)];
                long documentID = 10000000 + rand.nextInt(90000000);
                String name = NAMES[rand.nextInt(NAMES.length)];
                String lastName = LAST_NAMES[rand.nextInt(LAST_NAMES.length)];
                String section = SECTION[rand.nextInt(SECTION.length)];
                double salary = salaryCalculate(section);

                writer.write(documentType + ";" + documentID + ";" + name + ";" + lastName + ";" + section + ";" + salary + "\n");
            }
            System.out.println("CSV file generated successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    	// The following code block reads and displays the generated CSV file
    
    public static void readWorkersCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("List of workers:");
            System.out.println("----------------------------------------------------------");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading to file: " + e.getMessage());
        }
    }

    	// This code block show a specific salary depending on the job section.
    
    private static double salaryCalculate(String section) {
        
        switch (section) {
            case "Lathe Operator":
                return 2100; 
            case "Mill Operator":
                return 2200; 
            case "Conventional Operator":
                return 1700; 
            default:
                return 1700;
        }
    }

    	// Main method to execute the generation and reading of the CSV file.
    	// It can be modified so that the list shows more than 20 workers
    
    public static void main(String[] args) {
        String filePath = "workers_info.csv"; // CSV file name
        createWorkersCSV(filePath, 20);       // Generate workers
        readWorkersCSV(filePath);             // Read the file 
    }
}


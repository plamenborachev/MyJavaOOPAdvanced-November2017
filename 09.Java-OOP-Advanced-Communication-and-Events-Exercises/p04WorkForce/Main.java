package p04WorkForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] command = reader.readLine().split("\\s+");

        Company company = new CompanyImpl();

        Map<String, Employee> employees = new LinkedHashMap<>();

        while (!"End".equals(command[0])){
            switch (command[0]){
                case "Job":
                    Observer job = new Job(command[1], Integer.parseInt(command[2]), employees.get(command[3]), company);
                    company.attach(job);
                    break;
                case "StandartEmployee":
                    Employee standartEmployee = new StandartEmployee(command[1]);
                    employees.putIfAbsent(standartEmployee.getName(), standartEmployee);
                    break;
                case "PartTimeEmployee":
                    Employee partTimeEmployee = new PartTimeEmployee(command[1]);
                    employees.putIfAbsent(partTimeEmployee.getName(), partTimeEmployee);
                    break;
                case "Pass":
                    company.notifyAllObservers();
                    company.clearJobsDone();
                    break;
                case "Status":
                    System.out.println(company.status());;
                    break;
            }
            command = reader.readLine().split("\\s+");
        }
    }
}

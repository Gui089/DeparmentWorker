package Exer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department s name: ");
        String departmentName = sc.nextLine();
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
                new Department(departmentName));

        System.out.print("How many caracts to this worker ?");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter contract #" + i + "data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Durantion (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addConytact(contract);
        }

        System.out.println();
        System.out.print("Enter month and year calculate income (MM/YYYY): ");
        String monthYear = sc.next();
        int month = Integer.parseInt(monthYear.substring(0, 2));
        int year = Integer.parseInt(monthYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Deparment: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthYear + ":" + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}

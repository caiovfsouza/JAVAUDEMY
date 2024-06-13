package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramEmployee {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> listEmployee = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("entities.Employee #" + (i + 1) + ":");
            System.out.print("Id: ");
            int id = sc.nextInt();
            while (hasId(listEmployee , id)) {
                System.out.println("Id already taken! Try again: ");
                id = sc.nextInt();
            }
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();
            System.out.println();

            Employee employee = new Employee(id, name, salary);
            listEmployee.add(employee);
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int idSalary = sc.nextInt();
        Employee emp = listEmployee.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);// Ou pode usar a funsão – Integer pos = position(listEmployee, idSalary);

        if (emp == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            emp.increaseSalary(percent);
        }

        System.out.println();
        System.out.println("List os employee:");
        for (Employee employee : listEmployee) {
            System.out.println(employee.toString());
        }

        sc.close();
    }


    //Funções usadas no código

    //Para forçar digitar um id diferente dos que já existe.
    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }

    // Para encontrar um id válido e retornar a posicao dele para incrementar o idSalary
    public static Integer position(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
}

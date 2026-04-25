package Challenge8_Inheritance;

public class Employees {

    public static class Worker {
        private String name;
        private int birthYear;

        public Worker(String name, int birthYear) {
            this.name = name;
            this.birthYear = birthYear;
        }

        public int getAge() {
            return 2026 - birthYear;
        }

        @Override
        public String toString() {
            return name + " (age: " + getAge() + ")";
        }
    }

    public static class Employee extends Worker {
        private String hireDate;

        public Employee(String name, int birthYear, String hireDate) {
            super(name, birthYear);
            this.hireDate = hireDate;
        }

        public double collectPay() {
            return 0;
        }

        @Override
        public String toString() {
            return super.toString() + ", hired: " + hireDate;
        }
    }

    public static class SalariedEmployee extends Employee {
        private double annualSalary;
        private boolean retired;

        public SalariedEmployee(String name, int birthYear, String hireDate, double annualSalary) {
            super(name, birthYear, hireDate);
            this.annualSalary = annualSalary;
            this.retired = false;
        }

        @Override
        public double collectPay() {
            if (retired) {
                return annualSalary * 0.5;
            }
            return annualSalary / 12;
        }

        public void retire() {
            retired = true;
        }
    }

    public static class HourlyEmployee extends Employee {
        private double hourlyRate;
        private int hoursWorked;

        public HourlyEmployee(String name, int birthYear, String hireDate, double hourlyRate, int hoursWorked) {
            super(name, birthYear, hireDate);
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }

        @Override
        public double collectPay() {
            return hourlyRate * hoursWorked;
        }

        public double getDoublePay() {
            if (hoursWorked > 40) {
                return (hoursWorked - 40) * hourlyRate * 2;
            }
            return 0;
        }
    }
}
package com.mindex.challenge.data;

import java.util.List;

public class ReportingStructure {

    private Employee employee;

    private int numberOfReports;

    public ReportingStructure(Employee employee) {
        this.employee = employee;
        this.numberOfReports = -1;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getNumberOfReports() {
        if (this.numberOfReports == -1) {
            setNumberOfReports();
        }
        return numberOfReports;
    }

    private void setNumberOfReports() {
        this.numberOfReports = getNumberOfReports(employee);
    }

    private int getNumberOfReports(Employee employee) {
        int directReportCount = 0;
        List<Employee> directReports = employee.getDirectReports();
        if (directReports != null) {
            directReportCount += directReports.size(); // 2

            for (Employee emp : directReports) {
                directReportCount += getNumberOfReports(emp);
            }
        }
        return directReportCount;
    }
}

package org.CFT.api;

import org.CFT.cli.SalesEmployee;
import org.CFT.cli.SalesEmployeeRequest;
import org.CFT.client.FailedToCreateSalesEmployeeException;
import org.CFT.client.FailedToGetSalesEmployeeException;
import org.CFT.client.FailedToUpdateSalesEmployeeException;
import org.CFT.client.InvalidSalesEmployeeException;
import org.CFT.core.SalesEmployeeValidator;
import org.CFT.db.SalesEmployeeDao;
import org.CFT.db.SalesEmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class SalesEmployeeService {

    private SalesEmployeeDao salesEmployeeDao = new SalesEmployeeDao();

    private SalesEmployeeValidator salesEmployeeValidator = new SalesEmployeeValidator();

    public int createSalesEmployee(SalesEmployeeRequest sales_employee) throws FailedToCreateSalesEmployeeException, InvalidSalesEmployeeException {

        try {
            String validation = salesEmployeeValidator.isValidOrder(sales_employee);

            if (validation != null) {
                throw new InvalidSalesEmployeeException(validation);
            }

            int id = salesEmployeeDao.createSalesEmployee(sales_employee);

            if (id == -1) {
                throw new FailedToCreateSalesEmployeeException();
            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateSalesEmployeeException();
        }
    }
    public void updateSalesEmployee(int id, SalesEmployeeRequest sales_employee) throws InvalidSalesEmployeeException, SalesEmployeeDoesNotExistException, FailedToUpdateSalesEmployeeException {
        try {
            String validation = salesEmployeeValidator.isValidSalesEmployee(sales_employee);

            if (validation != null) {
                throw new InvalidSalesEmployeeException(validation);
            }

            SalesEmployee salesEmployeeToUpdate = salesEmployeeDao.getSalesEmployeeById(id);

            if (salesEmployeeToUpdate == null) {
                throw new SalesEmployeeDoesNotExistException();
            }

            salesEmployeeDao.updateSalesEmployee(id, sales_employee);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateSalesEmployeeException();
        }
    }
    public List<SalesEmployee> getAllSalesEmployees() throws FailedToGetSalesEmployeeException {
        try {
            List<SalesEmployee> salesEmployeeList = salesEmployeeDao.getAllSalesEmployees();

            return salesEmployeeList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetSalesEmployeeException();
        }


    }
    public SalesEmployee getSalesEmployeeById(int id) throws FailedToGetSalesEmployeeException, SalesEmployeeDoesNotExistException {
        try {
            SalesEmployee sales_employee = salesEmployeeDao.getSalesEmployeeById(id);

            if (sales_employee == null) {
                throw new SalesEmployeeDoesNotExistException();
            }
            return sales_employee;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetSalesEmployeeException();
        }
    }
}

package org.CFT.api;

import org.CFT.cli.DeliveryEmployee;
import org.CFT.cli.DeliveryEmployeeRequest;
import org.CFT.client.*;
import org.CFT.core.DeliveryEmployeeValidator;
import org.CFT.db.DeliveryEmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class DeliveryEmployeeService {

    private DeliveryEmployeeDao deliveryEmployeeDao = new DeliveryEmployeeDao();

    private DeliveryEmployeeValidator deliveryEmployeeValidator = new DeliveryEmployeeValidator();

    public int createDeliveryEmployee(DeliveryEmployeeRequest delivery_employee) throws FailedToCreateDeliveryEmployeeException, InvalidDeliveryEmployeeException {

        try {
            String validation = deliveryEmployeeValidator.isValidDeliveryEmployee(delivery_employee);

            if (validation != null) {
                throw new InvalidDeliveryEmployeeException(validation);
            }

            int id = deliveryEmployeeDao.createDeliveryEmployee(delivery_employee);

            if (id == -1) {
                throw new FailedToCreateDeliveryEmployeeException();
            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateDeliveryEmployeeException();
        }
    }
    public void updateDeliveryEmployee(int id, DeliveryEmployeeRequest delivery_employee) throws InvalidDeliveryEmployeeException, DeliveryEmployeeDoesNotExistException, FailedToUpdateDeliveryEmployeeException {
        try {
            String validation = deliveryEmployeeValidator.isValidDeliveryEmployee(delivery_employee);

            if (validation != null) {
                throw new InvalidDeliveryEmployeeException(validation);
            }

            DeliveryEmployee deliveryEmployeeToUpdate = deliveryEmployeeDao.getDeliveryEmployeeById(id);

            if (deliveryEmployeeToUpdate == null) {
                throw new DeliveryEmployeeDoesNotExistException();
            }

            deliveryEmployeeDao.updateDeliveryEmployee(id, delivery_employee);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateDeliveryEmployeeException();
        }
    }
    public List<DeliveryEmployee> getAllDeliveryEmployees() throws FailedToGetDeliveryEmployeeException {
        try {
            List<DeliveryEmployee> deliveryEmployeeList = deliveryEmployeeDao.getAllDeliveryEmployees();

            return deliveryEmployeeList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetDeliveryEmployeeException();
        }


    }
    public DeliveryEmployee getDeliveryEmployeeById(int id) throws FailedToGetDeliveryEmployeeException, DeliveryEmployeeDoesNotExistException {
        try {
            DeliveryEmployee delivery_employee = deliveryEmployeeDao.getDeliveryEmployeeById(id);

            if (delivery_employee == null) {
                throw new DeliveryEmployeeDoesNotExistException();
            }
            return delivery_employee;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetDeliveryEmployeeException();
        }
    }

    public void deleteDeliveryEmployee(int id) throws DeliveryEmployeeDoesNotExistException, FailedToDeleteDeliveryEmployeeException {
        try {
            DeliveryEmployee delivery_employee_to_delete = deliveryEmployeeDao.getDeliveryEmployeeById(id);

            if (delivery_employee_to_delete == null) {
                throw new DeliveryEmployeeDoesNotExistException();
            }
            deliveryEmployeeDao.deleteDeliveryEmployee(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToDeleteDeliveryEmployeeException();
        }
    }
}

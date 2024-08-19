package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NonRepetableRead {

    public void deleteEmployees() {

        try {
            Class.forName(ConnectionConstants.driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        }

        final String deleteQuery = "DELETE FROM Employee WHERE id = 12";

        try (Connection connection = DriverManager.getConnection(ConnectionConstants.url,
                ConnectionConstants.username, ConnectionConstants.password);

             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            connection.setAutoCommit(false);

            int updateCount = preparedStatement.executeUpdate();

            System.out.println("Deleted a record in the employee table");

            connection.commit();
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public void saveEmployee() {

        try {
            Class.forName(ConnectionConstants.driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        }

        final String sqlToInsertStudentRecord = "INSERT INTO Employee VALUES (12, 'IT 3', 58, 3, 2)";

        try (Connection connection = DriverManager.getConnection(ConnectionConstants.url,
                ConnectionConstants.username, ConnectionConstants.password);
             PreparedStatement insertStudentRecordStatement = connection.prepareStatement(sqlToInsertStudentRecord);
        ) {
            connection.setAutoCommit(false);

            int updateCount = insertStudentRecordStatement.executeUpdate();

            System.out.println("Inserted a record in the employee table");

            connection.commit();
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public void updateEmployeeById() {

        try {
            Class.forName(ConnectionConstants.driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        }

        final String sqlToInsertStudentRecord = "UPDATE Employee set fullName = 'Rahul' where id = 12";

        try (Connection connection = DriverManager.getConnection(ConnectionConstants.url,
                ConnectionConstants.username, ConnectionConstants.password);
             PreparedStatement insertStudentRecordStatement = connection.prepareStatement(sqlToInsertStudentRecord);
        ) {
            connection.setAutoCommit(false);

            int updateCount = insertStudentRecordStatement.executeUpdate();

            System.out.println("Inserted a record in the employee table");
            Thread.sleep(3000);

            connection.commit();
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public void getEmployeeById(boolean withWait) {

        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " - Executing thread");

        try {
            Class.forName(ConnectionConstants.driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        }

        final String sqlToGetStudentBasedOnMarks = "SELECT fullname FROM Employee WHERE id = 12";

        try (Connection connection = DriverManager.getConnection(ConnectionConstants.url,
                ConnectionConstants.username, ConnectionConstants.password);
             PreparedStatement getStudentBasedOnMarksStatement = connection.prepareStatement(sqlToGetStudentBasedOnMarks);
        ) {
            /**
             *  Setting TRANSACTION_READ_COMMITTED in the below line will result in the 2nd select to print
             *  Rahul instead of HR 3 indicating the non-repeatable read problem.
             *  Also by default my sql transaction isolation is TRANSACTION_REPEATABLE_READ which is why removing
             *  or commenting the line below will have the same effect as setting it to TRANSACTION_REPEATABLE_READ
             * */
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            System.out.println(threadName + " About to execute the query");

            try (ResultSet resultSet = getStudentBasedOnMarksStatement.executeQuery()) {

                System.out.println(threadName + " Thread is printing");

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("fullname"));
                }
            }
            System.out.println(threadName + " extracts result set successfully");

            System.out.println(threadName + " going to sleep.........");
            Thread.sleep(8000);
            System.out.println(threadName + " waking up");

            System.out.println(threadName + " About to execute the query again");

            try (ResultSet resultSet = getStudentBasedOnMarksStatement.executeQuery()) {

                System.out.println(threadName + " Thread is printing");

                while (resultSet.next()) {

                    System.out.println(resultSet.getString("fullname"));
                }
            }
            System.out.println(threadName + " extracts result set successfully");

            connection.commit();

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static void main(String[] args) {
        NonRepetableRead nonRepetableRead = new NonRepetableRead();
        nonRepetableRead.deleteEmployees();
        nonRepetableRead.saveEmployee();

        Thread nonRepetableReadInsertThread = new Thread(new Runnable() {
            @Override
            public void run() {
                nonRepetableRead.updateEmployeeById();
            }
        }, "Insert Employee Thread");


        Thread nonRepetableReadGetRecordsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                nonRepetableRead.getEmployeeById(false);
            }
        }, "Get Employee Thread");

         nonRepetableReadGetRecordsThread.start();
         nonRepetableReadInsertThread.start();
    }
}

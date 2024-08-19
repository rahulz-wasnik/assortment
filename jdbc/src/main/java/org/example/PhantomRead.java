package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PhantomRead {

    public void deleteEmployees() {

        try {
            Class.forName(ConnectionConstants.driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        }

        final String deleteQuery = "DELETE FROM Employee WHERE id = 12";

        try (Connection connection = DriverManager.getConnection(ConnectionConstants.url,
                ConnectionConstants.username, ConnectionConstants.password);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        ) {
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
            // For my sql its by default TRANSACTION_REPEATABLE_READ
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            int updateCount = insertStudentRecordStatement.executeUpdate();

            connection.commit();

            System.out.println("Inserted a record in the employee table "+ updateCount);
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
            /* TRANSACTION_SERIALIZABLE causes TWO ROWS to be fetched in both the selects */
            connection.setAutoCommit(false);
            // For my sql its by default TRANSACTION_REPEATABLE_READ
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            System.out.println(threadName + " About to execute the query");

            try (ResultSet resultSet = getStudentBasedOnMarksStatement.executeQuery()) {

                System.out.println(threadName + " Thread is printing");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("fullname"));
                }
            }
            System.out.println(threadName + " extracts result set successfully");

            System.out.println(threadName + " going to sleep.........");
            Thread.sleep(3000);
            System.out.println(threadName + " waking up");

            System.out.println(threadName + " About to execute the query again");

            try (ResultSet resultSet = getStudentBasedOnMarksStatement.executeQuery()) {

                System.out.println(threadName + " Thread is printing again");

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
        PhantomRead phantomRead = new PhantomRead();
        phantomRead.deleteEmployees();
        phantomRead.saveEmployee();

        Thread phantomReadInsertThread = new Thread(new Runnable() {
            @Override
            public void run() {
                phantomRead.saveEmployee();
            }
        }, "Insert Another Employee Thread");


        Thread phantomReadGetRecordsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                phantomRead.getEmployeeById(false);
            }
        }, "Get Employee Thread");

        phantomReadGetRecordsThread.start();
        phantomReadInsertThread.start();
    }
}

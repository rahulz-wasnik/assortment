package org.example;

import java.sql.*;

public class ReadFromDb {

    public void getAllEmployees() {

        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " - Executing thread");

        try {
            Class.forName(ConnectionConstants.driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        }

        final String sqlToGetStudentBasedOnMarks = "SELECT * FROM Employee FOR UPDATE";

        try (Connection connection = DriverManager.getConnection(ConnectionConstants.url,
                ConnectionConstants.username, ConnectionConstants.password);
             PreparedStatement getStudentBasedOnMarksStatement = connection.prepareStatement(sqlToGetStudentBasedOnMarks,
                     ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ) {

            connection.setAutoCommit(false);

            System.out.println(threadName + " About to execute the query");
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

    public void getEmployeeById(boolean withWait, int id) {

        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " - Executing thread");

        try {
            Class.forName(ConnectionConstants.driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        }

        final String sqlToGetStudentBasedOnMarks = "SELECT fullname FROM Employee WHERE id = ? FOR UPDATE";

        try (Connection connection = DriverManager.getConnection(ConnectionConstants.url,
                ConnectionConstants.username, ConnectionConstants.password);
             PreparedStatement getStudentBasedOnMarksStatement = connection.prepareStatement(sqlToGetStudentBasedOnMarks,
                     ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ) {

            connection.setAutoCommit(false);
            getStudentBasedOnMarksStatement.setInt(1, id);
            System.out.println(threadName + " About to execute the query");
            try (ResultSet resultSet = getStudentBasedOnMarksStatement.executeQuery()) {

                if (withWait) {
                    System.out.println(threadName + " is going to sleep");
                    Thread.sleep(10000);
                }

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


    public void getEmployeeByName(boolean withWait, String name) {

        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " - Executing thread");

        try {
            Class.forName(ConnectionConstants.driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        }

        final String sqlToGetStudentBasedOnMarks = "SELECT fullname FROM Employee WHERE fullname = ?";

        try (Connection connection = DriverManager.getConnection(ConnectionConstants.url,
                ConnectionConstants.username, ConnectionConstants.password);
             PreparedStatement getStudentBasedOnMarksStatement = connection.prepareStatement(sqlToGetStudentBasedOnMarks);
        ) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            getStudentBasedOnMarksStatement.setString(1, name);
            System.out.println(threadName + " About to execute the query");
            try (ResultSet resultSet = getStudentBasedOnMarksStatement.executeQuery()) {

                if (withWait) {
                    System.out.println(threadName + " is going to sleep");
                    Thread.sleep(10000);
                }

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

    public void getManagerAndAllHisReportingEmployees(int id) {

        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " - Executing thread");

        try {
            Class.forName(ConnectionConstants.driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        }

        /* Surprisingly don't see the alias name in the metadata of result set as the column name */
        final String sqlToGetStudentBasedOnMarks = "select e.id as mgr_id, e1.id as reporting_emp_id, e1.fullname from `jdbc`.Employee e join `jdbc`.Employee e1 where e1.mgr_id = e.id and e1.mgr_id = ?";

        try (Connection connection = DriverManager.getConnection(ConnectionConstants.url,
                ConnectionConstants.username, ConnectionConstants.password);
             PreparedStatement getStudentBasedOnMarksStatement = connection.prepareStatement(sqlToGetStudentBasedOnMarks,
                     ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ) {

            connection.setAutoCommit(false);
            getStudentBasedOnMarksStatement.setInt(1, id);
            System.out.println(threadName + " About to execute the query");
            try (ResultSet resultSet = getStudentBasedOnMarksStatement.executeQuery()) {

                System.out.println(threadName + " Thread is printing");
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int count = resultSetMetaData.getColumnCount();
                for(int i = 1; i<=count; i++) {
                    System.out.println(resultSetMetaData.getColumnName(i));
                }
            }
            System.out.println(threadName + " extracts result set successfully");

            connection.commit();

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}

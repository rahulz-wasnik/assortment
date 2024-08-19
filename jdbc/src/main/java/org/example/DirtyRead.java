package org.example;

import java.sql.*;

public class DirtyRead {

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

            // System.out.println("Deleted a record in the employee table");

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

            // System.out.println("Inserted a record in the employee table");

            connection.commit();
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public void updateEmployeeById() {

        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " - Executing thread");

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

            Savepoint savepointBeforeInsert = connection.setSavepoint("savepointBeforeInsert");

            int updateCount = insertStudentRecordStatement.executeUpdate();

            System.out.println(threadName + " Updated a record in the employee table");
            Thread.sleep(5000);
            connection.rollback(savepointBeforeInsert);

            System.out.println(threadName + " rollback the update");

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
            Thread.sleep(1);

            /**
             * Dirty read occurs when one row is being updated by an update transaction but before this transaction
             * a select transaction reads the same value and gets the value updated by the update transaction. So now
             * if the update transaction is rollback and a select transaction is executed again the second select
             * will then get a previous value which was the same as before the update transaction ever happened. This is
             * the dirty read problem where the first select has essentially read a value which is uncommitted and stale.
             *
             * Using TRANSACTION_READ_UNCOMMITTED will cause the first select to display Rahul which is an
             * uncommitted value which will be rolled back after 15 seconds delay after which second read
             * will display IT 3 as the name indicating the dirty read problem.
             *
             * Changing the transaction level to TRANSACTION_READ_COMMITTED displays the value as IT 3 for both selects
             * essentially solving the dirty read problem
             *
             * Using TRANSACTION_READ_COMMITTED essentially means whenever user is performing insert update and deletes user
             * cannot read the data
             */
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
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

    public static void main(String[] args) throws InterruptedException {
        DirtyRead dirtyRead = new DirtyRead();
        dirtyRead.deleteEmployees();
        dirtyRead.saveEmployee();

        Thread insertThread = new Thread(new Runnable() {
            @Override
            public void run() {
                dirtyRead.updateEmployeeById();
            }
        }, "Updated Employee Thread");


        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                dirtyRead.getEmployeeById(false);
            }
        }, "Get Employee Thread");

        Thread readAgainThread = new Thread(new Runnable() {
            @Override
            public void run() {
                dirtyRead.getEmployeeById(false);
            }
        }, "Get Employee Again Thread");

        insertThread.start();
        readThread.start();

        insertThread.join();
        readAgainThread.start();
    }
}

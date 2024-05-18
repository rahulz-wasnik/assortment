package org.example;

import java.sql.*;

public class InsertIntoDb {

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

//            Savepoint savepointBeforeInsert = connection.setSavepoint("savepointBeforeInsert");

            int updateCount = insertStudentRecordStatement.executeUpdate();

            System.out.println("Inserted a record in the employee table");

//            connection.rollback(savepointBeforeInsert);

            connection.commit();
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}

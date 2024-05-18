package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ReadFromDb readFromDb = new ReadFromDb();

        ExecuteRead executeReadA = new ExecuteRead(readFromDb, true, 1);
        ExecuteRead executeReadB = new ExecuteRead(readFromDb, false, 1);

        Thread threadA = new Thread(executeReadA, "Reader A");
        Thread threadB = new Thread(executeReadB, "Reader B");

        /* Locking at table level using select for update */
        // threadA.start();
        // Thread.sleep(4000);
        // threadB.start();

        /* Read manager and all his reporting employees */
        // readFromDb.getManagerAndAllHisReportingEmployees(1);

    }
}

class ExecuteRead implements Runnable {

    private final ReadFromDb readFromDb;
    private final boolean withWait;
    private final int id;

    public ExecuteRead(ReadFromDb readFromDb, boolean withWait, int marks) {
        this.readFromDb = readFromDb;
        this.withWait = withWait;
        this.id = marks;
    }

    @Override
    public void run() {
        readFromDb.getEmployeeById(withWait, id);
    }
}
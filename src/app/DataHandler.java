package app;

import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {

    private String[] fruits = new DataRepository().getData();
    private AtomicInteger count = new AtomicInteger(1);

    public void getOutput() {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            for (String fruit : fruits) {
                sb.append(String.format("(%d) %s ",
                        count.getAndIncrement(), fruit));
            }
            System.out.println(Thread.currentThread().getName() + ": " + sb);
        }
    }
}
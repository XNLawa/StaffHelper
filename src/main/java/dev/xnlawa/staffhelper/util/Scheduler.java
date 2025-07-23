package dev.xnlawa.staffhelper.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {

    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

    public static void runAsync(Runnable task) {
        executor.execute(task);
    }

    public static void runLater(Runnable task, long delayTicks) {
        executor.schedule(task, ticksToMillis(delayTicks), TimeUnit.MILLISECONDS);
    }

    public static void runTimer(Runnable task, long delayTicks, long periodTicks) {
        executor.scheduleAtFixedRate(task,
                ticksToMillis(delayTicks),
                ticksToMillis(periodTicks),
                TimeUnit.MILLISECONDS);
    }

    private static long ticksToMillis(long ticks) {
        return ticks * 50L;
    }

    public static void shutdown() {
        executor.shutdownNow();
    }
}

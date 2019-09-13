import com.test.service.RunnableTask;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

public class ThreadPoolTaskSchedulerTest {
    public static void main(String[] args) {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.initialize();
        taskScheduler.schedule(
//                new RunnableTask("Specific time, 3 Seconds from now"),
//                new Date(System.currentTimeMillis() + 3000)
                new RunnableTask("Cron Trigger"), new CronTrigger("0/3 * * * * *")
        );
        taskScheduler.schedule(
                new RunnableTask("Cron Trigger222"), new CronTrigger("0/5 * * * * *")
        );
    }
}

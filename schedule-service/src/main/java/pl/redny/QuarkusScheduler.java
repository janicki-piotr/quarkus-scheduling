package pl.redny;

import io.quarkus.scheduler.Scheduled;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class QuarkusScheduler {

    @Inject
    @RestClient
    CounterAPIClient counterAPIClient;

    @Transactional
    @Scheduled(every = "10s", identity = "task-job")
    void increment() throws InterruptedException {
        Task task = new Task();
        task.persist();
        counterAPIClient.increaseCounter("scheduler");
    }
}

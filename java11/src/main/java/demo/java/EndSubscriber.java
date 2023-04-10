package demo.java;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicInteger;

public class EndSubscriber<T> implements Flow.Subscriber<T> {

    private Flow.Subscription subscription;
    private final AtomicInteger howMuchMessagesConsume;
    final List<T> consumedElements = Lists.newArrayList();

    public EndSubscriber(final int howMuchMessagesConsume) {
        this.howMuchMessagesConsume = new AtomicInteger(howMuchMessagesConsume);
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        howMuchMessagesConsume.decrementAndGet();
        System.out.println("Got Item :: " + item);
        consumedElements.add(item);
        if (howMuchMessagesConsume.get() > 0) {
            subscription.request(1);
        }
    }

    @Override
    public void onError(Throwable t) {
        System.err.println("Got Error");
        t.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}

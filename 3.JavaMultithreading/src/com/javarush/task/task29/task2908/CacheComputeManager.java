package com.javarush.task.task29.task2908;

import java.util.concurrent.*;

/*
Кеширование

В CacheComputeManager реализуй логику пустого метода.
Догадайся, что он должен делать по названию метода и по логике класса.

Требования:
1. Метод createFutureTaskForNewArgumentThatHasToComputeValue() должен создавать и возвращать объект типа FutureTask.
2. В методе createFutureTaskForNewArgumentThatHasToComputeValue() должен создаваться объект анонимного класса, реализующего интерфейс Callable.
3. Внутри метода createFutureTaskForNewArgumentThatHasToComputeValue() должна встречаться строка "return computable.compute(arg);".
4. Программа должна выводить текст указанный в комментариях в классе Solution.
*/

public class CacheComputeManager<Argument, Value> implements Computable<Argument, Value> {
    private final ConcurrentHashMap<Argument, Future<Value>> cache = new ConcurrentHashMap<>();
    private final Computable<Argument, Value> computable;

    public CacheComputeManager(Computable<Argument, Value> computable) {
        this.computable = computable;
    }

    @Override
    public Value compute(final Argument arg) throws InterruptedException {
        Future<Value> f = cache.get(arg);
        if (f == null) {
            FutureTask<Value> ft = createFutureTaskForNewArgumentThatHasToComputeValue(arg);
            cache.putIfAbsent(arg, ft);
            f = ft;
            ft.run();
            System.out.print(arg + " will be cached  ");
        } else {
            System.out.print(arg + " taken from cache  ");
        }
        try {
            return f.get();
        } catch (CancellationException e) {
            cache.remove(arg, f);
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
        return null;
    }

    public FutureTask<Value> createFutureTaskForNewArgumentThatHasToComputeValue(final Argument arg) {
        FutureTask<Value> futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return computable.compute(arg);
            }
        });

        return futureTask;
    }
}

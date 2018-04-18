package java5;

import java.util.concurrent.Callable;

public class CUPDTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("creating CUPD msg, thread id="+Thread.currentThread().getId());
        Thread.sleep(8000);
        System.out.println("end response Rich media, thread id="+Thread.currentThread().getId());
        return new Integer(10);
    }
}

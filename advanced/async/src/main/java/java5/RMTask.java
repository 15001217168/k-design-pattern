package java5;

import java.util.concurrent.Callable;

public class RMTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("creating response Rich media, thread id="+Thread.currentThread().getId());
        Thread.sleep(3000);
        System.out.println("end response Rich media, thread id="+Thread.currentThread().getId());
        return new Integer(3);
    }
}

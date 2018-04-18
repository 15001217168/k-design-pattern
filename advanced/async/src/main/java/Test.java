
import  java1.*;
import java5.CUPDTask;
import java5.RMTask;

import java.util.concurrent.*;

public class Test {
    public  static  void  main(String [] args)
    {
        // TODO Auto-generated method stub
//        System.out.println("get request from TC thread id="+Thread.currentThread().getId());
//        Runnable createRM = new CreateRichMedia("Thread RM");
//        new Thread(createRM).start();
//
//        Runnable tCUPD=new SendToCUPD("Thread CUPD");
//        new Thread(tCUPD).start();
//        System.out.println("End main method");

        // ES
        System.out.println("Get request from TC, thread id="+Thread.currentThread().getId());
        ExecutorService ES=Executors.newCachedThreadPool();

        //task
        Callable<Integer> rmTask= new RMTask();
        Callable<Integer> cupdTask = new CUPDTask();

        //ES submit task,
        //param is callable
        //return result
        Future<Integer> rmResult=ES.submit(rmTask);
        Future<Integer> cupdResult= ES.submit(cupdTask);
        ES.shutdown();

        System.out.println("ES shutdown, thread id="+Thread.currentThread().getId());
        //ES shutdown

        try {
            Integer result = rmResult.get();
            System.out.println("process rmResult, thread id="+Thread.currentThread().getId());
            System.out.println("process rmResult="+result);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}

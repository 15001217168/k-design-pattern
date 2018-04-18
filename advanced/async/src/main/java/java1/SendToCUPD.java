package java1;

public class SendToCUPD implements  Runnable {

    private  String name;
    public SendToCUPD(String name) {
        this.name=name;
    }

    public void run() {
        System.out.println("b4 send to cupd");
        try {
            System.out.println(" sending to cupd, thread id="+Thread.currentThread().getId());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("end send to cupd");
    }
}

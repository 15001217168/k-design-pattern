package java1;

public class CreateRichMedia implements  Runnable {
    public String TName;
    public CreateRichMedia(String TName) {
        // TODO Auto-generated constructor stub
        this.TName=TName;
    }

    @Override
    public void run() {

        System.out.println("start response Rich media");
        try {
            System.out.println("creating response Rich media, thread id="+Thread.currentThread().getId());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("End response Rich media");
    }
}

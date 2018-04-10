public class Client {
    private CompositeEntity compositeEntity = new CompositeEntity();

    public void printData() {
        String[] data = compositeEntity.getData();
        for (int i = 0; i < data.length; i++) {
            System.out.println("Data: " + data[i]);
        }
    }
    public void setData(String data1, String data2){
        compositeEntity.setData(data1, data2);
    }
}

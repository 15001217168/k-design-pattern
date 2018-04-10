/*
 * 单例模式(饿汉式,推荐)
 * */
public class SingleObject {
    private static SingleObject _instance = new SingleObject();

    private SingleObject()
    {
    }

    public  static SingleObject getInstance()
    {
        return  _instance;
    }
    public  void  showMessage()
    {
        System.out.println("你好");
    }
}

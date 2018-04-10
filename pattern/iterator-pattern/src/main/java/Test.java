public class Test {
    public  static  void  main(String [] args)
    {
        NameRepository namesRepository = new NameRepository();

        for(IIterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}

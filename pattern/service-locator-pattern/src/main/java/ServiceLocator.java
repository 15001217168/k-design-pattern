public class ServiceLocator {
    private static Cache cache;

    //对静态变量赋值（JVM加载类时会执行这些静态的代码块，如果static代码块有多个，JVM将按照它们在类中出现的先后顺序依次执行它们，每个代码块只会被执行一次）
    static {
        cache = new Cache();
    }

    public static IService getService(String jndiName){

        IService service = cache.getService(jndiName);

        if(service != null){
            return service;
        }

        InitialContext context = new InitialContext();
        IService service1 = (IService)context.lookup(jndiName);
        cache.addService(service1);
        return service1;
    }
}

package utils;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(DriverType type){
        DriverManager driverManager;
        switch (type){
            case CHROME:
                driverManager = new ChromeDriverManager();

                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;

            case IE:
                driverManager = new IEDriverManager();
                break;

            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}

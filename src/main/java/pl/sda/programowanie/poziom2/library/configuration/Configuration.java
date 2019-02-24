package pl.sda.programowanie.poziom2.library.configuration;

public class Configuration {

    //wzorzec projektowy Singleton

    private static Configuration instance;

    private Configuration(){
    }

    //synchronized nie jest konieczne ale sprawia ze Singleton będzie działał w kodzie wielowątkowym
    public static synchronized Configuration getInstance(){
        if (instance == null){
            instance = new Configuration();
        }
        return instance;
    }
}

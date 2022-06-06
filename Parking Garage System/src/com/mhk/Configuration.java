package com.mhk;

// class singelton
public class Configuration {
    private String _config;
    private static Configuration _configuration;

    private Configuration(){};

    public static Configuration getInstance(){
        if(_configuration == null){
            _configuration = new Configuration();
        }
        return _configuration;
    }

    public void setConfig(String configuration){
        this._config = configuration;
    }

    public String getConfiguration(){
        return this._config;
    }

}

package com.example.itsc3;

public class DataManager {
    private static DataManager instance = null;
    private FormData formData;

    private DataManager(){
        formData = new FormData();
    }

    public static DataManager getInstance(){
        if (instance == null){
            instance = new DataManager();
        }
        return instance;
    }

    public FormData getFormData(){
        return formData;
    }
}

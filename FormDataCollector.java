package com.example.itsc3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FormDataCollector {
    private List<Map<String, String>> formDataList = new ArrayList<>();


    public void addFormData(Map<String, String> formData) {
        formDataList.add(formData);
    }

    public List<Map<String, String>> getFormDataList(){
        return formDataList;
    }
}

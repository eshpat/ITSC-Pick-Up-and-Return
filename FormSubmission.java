package com.example.itsc3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormSubmission {

    public static FormSubmission instance;
    private final List<Map<String, String>> formDataList;

    private FormSubmission() {
        formDataList = new ArrayList<>();
    }

    public static synchronized FormSubmission getInstance() {
        if (instance == null) {
            instance = new FormSubmission();
        }
        return instance;
    }

    public void addFormData(Map<String, String> formData) {
        formDataList.add(formData);
    }

    public List<Map<String, String>> getFormDataList() {
        return formDataList;
    }
}

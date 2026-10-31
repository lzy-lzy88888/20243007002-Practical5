package com.example.practicalfive;

public class TextProcessor {
    public static String processMunicipality(String municipality){
        if(municipality == null || municipality.trim().isEmpty()){
            return null;
        }
        String inputTrim = municipality.trim();
        if(inputTrim.equalsIgnoreCase("beijing")){
            return "Beijing";
        }else if(inputTrim.equalsIgnoreCase("shanghai")){
            return "Shanghai";
        }else if(inputTrim.equalsIgnoreCase("tianjin")){
            return "Tianjin";
        }else if(inputTrim.equalsIgnoreCase("chongqing")){
            return "Chongqing";
        }else{
            return null;
        }
    }
}

package com.abin.lee.kafka.consumer.test;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

public enum ApplicationSource {
    RD("仁德"), YM("医美");

    private String showName;

    ApplicationSource(String showName) {
        this.showName = showName;
    }

    public String getShowName() {
        return showName;
    }


    public static ApplicationSource getEnum(String param){
        if(StringUtils.isBlank(param))
            return null;
        for(ApplicationSource applicationSource:values()){
            if(StringUtils.equals(applicationSource.name(), param)){
                return applicationSource;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String param = "NULL";
//        String param = "";
        System.out.println(getEnum("DSF"));
        System.out.println(EnumUtils.isValidEnum(ApplicationSource.class, param));
    }

}

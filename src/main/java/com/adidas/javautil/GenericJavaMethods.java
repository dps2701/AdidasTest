package com.adidas.javautil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GenericJavaMethods{
private Properties properties;
private static GenericJavaMethods configReader;

   private GenericJavaMethods() {
BufferedReader reader;
    	String propertyFilePath = "Config//Config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        } 
}

   public static GenericJavaMethods getInstance( ) {
   	if(configReader == null) {
    configReader = new GenericJavaMethods();
   	}
       return configReader;
   }

   public String getBaseUrl() {
       String baseUrl = properties.getProperty("BASE_URL");
       if(baseUrl != null) return baseUrl;
       else throw new RuntimeException("base_Url not specified in the Config.properties file.");
   }
   public String getPostId() {
       String postId = properties.getProperty("postId");
       if(postId != null) return postId;
       else throw new RuntimeException("postId not specified in the Config.properties file.");
   }
   public String getPostName() {
       String postName = properties.getProperty("postName");
       if(postName != null) return postName;
       else throw new RuntimeException("postName not specified in the Config.properties file.");
   }
   public String getPostCategoryId() {
       String postCategoryId = properties.getProperty("postCategoryId");
       if(postCategoryId != null) return postCategoryId;
       else throw new RuntimeException("postCategoryId not specified in the Config.properties file.");
   }
   public String getPostCategoryName() {
       String postCategoryName = properties.getProperty("postCategoryName");
       if(postCategoryName != null) return postCategoryName;
       else throw new RuntimeException("postCategoryName not specified in the Config.properties file.");
   }
   public String getPostTagId() {
       String postTagId = properties.getProperty("postTagId");
       if(postTagId != null) return postTagId;
       else throw new RuntimeException("postTagId not specified in the Config.properties file.");
   }
   public String getPostTagName() {
       String postTagName = properties.getProperty("postTagName");
       if(postTagName != null) return postTagName;
       else throw new RuntimeException("postTagName not specified in the Config.properties file.");
   }
   public String getPostStatus() {
       String postStatus = properties.getProperty("postStatus");
       if(postStatus != null) return postStatus;
       else throw new RuntimeException("postStatus not specified in the Config.properties file.");
   }
   public String getPostUpdatedStatus() {
       String postUpdatedStatus = properties.getProperty("postUpdatedStatus");
       if(postUpdatedStatus != null) return postUpdatedStatus;
       else throw new RuntimeException("postUpdatedStatus not specified in the Config.properties file.");
   }
   
   public String getBrowserName() {
       String browserName = properties.getProperty("browserName");
       if(browserName != null) return browserName;
       else throw new RuntimeException("browserName not specified in the Config.properties file.");
   }
   public String getHomePageURL() {
       String url = properties.getProperty("URL");
       if(url != null) return url;
       else throw new RuntimeException("url not specified in the Config.properties file.");
   }
}

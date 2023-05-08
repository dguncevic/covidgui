/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coviddz;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author 19par
 */
public class Updater {
    
    public static String getJSON(){
        
        String jsonString= "";
        try{
            
            URL url = new URL("https://api.covid19api.com/summary");
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            int responseCode= conn.getResponseCode();
            
            if(responseCode != 200){
                throw new RuntimeException("HttpResponseCode: "+responseCode);
            }else{
                
                Scanner scanner = new Scanner(url.openStream());
                while(scanner.hasNext()){
                    jsonString += scanner.nextLine();
                }
                scanner.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonString;
    }
}

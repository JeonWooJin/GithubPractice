package com.example.jeonwoojin.captsone;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class CSVFile {
    InputStream inputStream;

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public String[][] read(){
        int rowcount = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try{
            String line;
            while((line = reader.readLine())!= null){
                rowcount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[][] matrix = new String[rowcount][6];
        try {
            int inputflag = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] temparr = line.split(",");
                for(int i = 0;i<temparr.length;i++){
                    matrix[inputflag][i] = temparr[i];
                }
                inputflag++;
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return matrix;
    }
}
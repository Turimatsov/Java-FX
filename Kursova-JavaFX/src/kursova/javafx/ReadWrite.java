package kursova.javafx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author hp
 */
public class ReadWrite {    
    public void writeKnigaToFile(String[] knigiData){
        File f = new File("Knigi"+".txt");
        PrintWriter p = null;
        try
        {
           p= new PrintWriter(new FileOutputStream(f, true));
            for(int i = 0; i < knigiData.length; i+=6){
                p.write(knigiData[i] + ":" + 
                        knigiData[i+1] + ":" + 
                        knigiData[i+2] + ":" + 
                        knigiData[i+3] + ":" + 
                        knigiData[i+4] + ":" + 
                        knigiData[i+5]);
                p.println();
            }
            p.close();
        }
        catch(Exception e)
        {
        System.exit(1);
        }
    }
    public ObservableList<String> readKnigaFromFile(){
        File f = new File("Knigi"+".txt");
        ObservableList<String> KnigiData = FXCollections.observableArrayList();
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            while(br.ready()){
                KnigiData.add(br.readLine());
            }
            br.close();
            fr.close();
        }catch(Exception e){
            System.out.println(e);
        }  
        return KnigiData;
    }
}

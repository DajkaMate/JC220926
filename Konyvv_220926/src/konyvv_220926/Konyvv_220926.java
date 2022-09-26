/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konyvv_220926;

import java.io.*;
import java.util.List;

public class Konyvv_220926 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       
        
        int szam = 10;   
        String[] tomb = new String[szam];
       
        try
        {
            FileReader fr = new FileReader("konyvek.txt");
            BufferedReader br = new BufferedReader(fr);
            String sor = null;
            int diakok = 0;
            
            
            String Szam = null;
            System.out.println("A fájl beolvasva!");
            System.out.println("Adatok:");
            int j = 0;
            for (int i = 0; i < 10; i++) {
                tomb[i]=br.readLine();    
            }
            
            diakok = tomb[1];
            br.close();     
            
            System.out.println(Szam);
        }       
        catch (IOException hiba)
        {
                System.out.println("A fájl nem található! " + hiba);
        }
       
    }
    
}

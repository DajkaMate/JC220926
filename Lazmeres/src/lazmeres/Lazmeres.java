/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazmeres;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author user08
 */
public class Lazmeres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();
        Scanner beolvasas = new Scanner(System.in);
        
        System.out.println("Hány számot szeretne generálni 10 és 100 között");
        
        int szam = 0;
        
        do
        {
            szam = beolvasas.nextInt();
        }
        while (szam < 10 || szam > 100);
        float tomb[];
        
        tomb = new float[szam];
        
        for (int i = 0; i < szam; i++) 
        {
            tomb[i] = r.nextFloat()*5+(float)36.5;
        }
        
        for (int j = 0; j < tomb.length; j++) 
        {
            System.out.printf("%.2f",tomb[j]);
            if (j<tomb.length-1) 
            {
                System.out.print("| ");
            }
        }
        System.out.println();
        System.out.println("Kérek egy számot 37-41 között! ");
        
        int db = 0;
        float laz = 0;
        laz=beolvasas.nextFloat();
        
        for (int i = 0; i < tomb.length; i++) 
        {
            if (laz <= tomb[i]+0.5 || laz >= tomb[i]-0.5)
            {
                db++;
            } 
  
        }
        System.out.println(db+"db. embernek volt a " +laz+ " fokor értéke (0.5 környezetében) ");
        
        int nemlazas = 0;   
        int hoemelkedes = 0;
        int nagyonlazas = 0;
        
        for (int i = 0; i < tomb.length; i++) 
        {
            /*
            if (tomb[i]<37) 
            {   
                nemlazas++;
            }
            
            if (tomb[i]>=37 || tomb[i] >= 37.5) 
            {
                hoemelkedes++;
            }
            
            if (tomb[i]>37.5)
            {
                nagyonlazas++;
            }
            */
            //vagy
            
            if (tomb[i]<37) 
            {   
                nemlazas++;
            }
            
            else if (tomb[i]>=37 && tomb[i] >= 37.5) 
            {
                hoemelkedes++;
            }
            
            else
            {
                nagyonlazas++;
            }
        }
            
        System.out.println();
        System.out.println("Ennyi ember nem volt lázas, sem hőemelkedése: " + nemlazas);
        System.out.println();
        System.out.println("Ennyi embernek volt hőemelkedése: " + hoemelkedes);
        System.out.println();
        System.out.println("Ennyi ember volt lázas " + nemlazas); 
        
        float rendezetttomb[];
        rendezetttomb = new float[szam];
        
        //g
        System.out.print("\nSorba redezve: ");
	for(int i = tomb.length-1; i > 0; i--) 
            for(int j=0; j<i; j++)
		if(tomb[j] > tomb[j+1])
		{
                    float tmp = tomb[j];
                    tomb[j] = tomb[j+1];
                    tomb[j+1] = tmp;
		}
 
		for(int i=0; i<tomb.length; i++)
                {
                    System.out.printf("%.2f, ",tomb[i]);
                    
                    rendezetttomb[i] = tomb[i];
                    
                }
		System.out.println();
                
               
                
                
        
        //h
        float osszeg = 0;
	for(int i=0; i<tomb.length; i++)
        {
            osszeg = osszeg + tomb[i];
        }
        float atlag = osszeg / tomb.length;
 
        System.out.printf("Az átlaghőmérséklet" + " %.2f, ",atlag);
        
        //i   
        try
        {
        System.setProperty("file.encoding", "UTF8");
        PrintWriter pw = new PrintWriter("text.txt");
            for (int i = 0; i < rendezetttomb.length; i++) 
            {
                pw.printf("%.2f, ",rendezetttomb[i]);
            }
        pw.close();
        System.out.println("\nAz adatokat kiírva!");
        }
        catch(IOException hiba)
        {
            System.out.println("Nincs meg a fálj!" + hiba);
        }
        
           
    }  
}

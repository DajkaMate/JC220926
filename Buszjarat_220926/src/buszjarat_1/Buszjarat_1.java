/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Java alap feladat feljegyeztük a utasok számát(busz.txt)
 * Fealdat: adatok eltárolása "utasok" nevü tömbe, ha nem található a file akkor hibaüzenettet kérünk
 * Kérdések: a, Összesen hány utas utazott az adott járaton, b, hány olyan nap volt amikor az utasszám meghaladta a 200 at,
 * c, melyik napon és menny volt a maximális napi utasszám, d, volt a olyan nap amikor az utasszám pot 200 volt.
 */
package buszjarat_1;

import java.util.Calendar;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 *
 * @author user08
 */
public class Buszjarat_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] utasok = new int[31];
        int i = 0;
        Calendar datum = Calendar.getInstance();
        
        System.out.printf("&tB\n",datum);
        
        Scanner olvaso = new Scanner(System.in);
        System.out.println("Milyen hónapban vagyunk(számmal adjuk meg):");
        while(i<1 || i>12)
        {
            i=olvaso.nextInt();
        }
        int napszam=31;
        switch(i){
            case 1:System.out.println("Januar");break;
            case 2:System.out.println("Februar");napszam=28;break;
            case 3:System.out.println("Msrcius");break;
            case 4:System.out.println("Aprilis");napszam=30;break;
            case 5:System.out.println("Majus");break;
            case 6:System.out.println("Junius");napszam=30;break;
            case 7:System.out.println("Julius");break;
            case 8:System.out.println("Augusztus");break;
            case 9:System.out.println("Szeptember");napszam=30;break;
            case 10:System.out.println("Oktober");break;
            case 11:System.out.println("November");napszam=28;break;
            case 12:System.out.println("December");;
        }
        try
        {
            System.setProperty("file.encoding", "UTF8");
            FileReader fajl = new FileReader("busz.txt");
            BufferedReader br = new BufferedReader(fajl);
            String sor = null;
            int j = 0 ;
            while((sor =br.readLine()) !=null){
                utasok[j]=Integer.valueOf(sor).intValue();
                j++;
            }
            br.close();
            System.out.println("Az adatokat kiírtam!");
        }
        catch(IOException hiba){
            System.out.println("Nincs meg a fajl"+hiba);
        }
        int osszesen = 0;
        int db = 0;
        int max = utasok[0];
        int nap = 1;
        boolean van = false;
        for(int k = 0; k < napszam; k++){
            osszesen += utasok[k];
            if (utasok[k]>200) {
                db++;
            }
            if(utasok[k]>max){
                max = utasok[k];
                nap=k+1;
            }
            if(utasok[k]==200){
                van=true;
            }
        }
        System.out.println("Mennyien utazztak" + osszesen + " .db");
        System.out.println("Kétszáz feletti utasok hany napon voltak: " + db + " db");
        System.out.println("Mennyi volt a max utasszam: " + max + " .db es ez a:" + nap + " .napon");
        if(van){
        System.out.println("Volt olyan nao, amikor 200-an voltak");
        }
        
    }
    
}

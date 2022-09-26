/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szinhaz_220926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class Keves_adat extends Exception
{
    private int Szam;
    Keves_adat(int szam)
        {
            Szam = szam;
        }
	public String toString()
	{
		return "Kevés a bejegyzések száma csak:" + " " + Szam;
	}
}

public class Szinhaz_220926 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {   
        int[] jegyeladas = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean ok = false;
        
        float bevetel = 0;
        try 
        {
            System.setProperty("file.encoding", "UTF8");
            FileReader fr = new FileReader("szinhaz.txt");
            BufferedReader br = new BufferedReader(fr);
            String sor = null;
            int j = 0;
                while((sor = br.readLine()) != null)
                {                
                    jegyeladas[j] = Integer.valueOf(sor); 
                    bevetel=bevetel+jegyeladas[j]*4000;
                    if (jegyeladas[j]>200)
                    {
                        ok=true;
                    } 
                    j++;
                }   
            br.close();
            
            
            
            if(j<14)
            {
                throw new Keves_adat(j);
            }
      
            else
            {
                System.out.println("A bejegyzesek rendben: " + j);
                System.out.println("A bevétel: "+bevetel+" van-e "+ok);
            }
        }
        
        catch(IOException hiba)
        {
            System.out.println("Nincs meg a fájl! " + hiba);
        } 
        
        catch (ArrayIndexOutOfBoundsException hiba)
        {
            System.out.println("Túl sok az adat! (max 14) " + hiba);
        }
        
        catch (NumberFormatException hiba)
        {
            System.out.println("Nem megfelelő adattípus" + hiba);
        }
    }   
}

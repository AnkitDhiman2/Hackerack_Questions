import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.lang.*;
import java.io.File;

public class program{

    
//mplete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        
        char [] arr = w.toCharArray();
        boolean possible = false;
        
        int pos = 0;
        for(int i = w.length()-1 ; i >= 0 ; i--)
        {
            for(int j = i - 1 ; j >= 0 ; j--)
            { 
                if(arr[j] < arr[i])
                {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    possible = true; 
                    pos = j;
                    break; 
                }  
            }
            if(possible)
                break;    
        }
        
        if(possible)
        {
            //Bubble sort
            for(int i = pos+1 ; i < w.length() ; i++)
            {
                boolean swapHappen = false;
                for(int k = i+1 ; k < w.length() ; k++)
                {
                    if(arr[i] > arr[k] )
                    {
                        char temp = arr[i];
                        arr[i] = arr[k];
                        arr[k] = temp;
                        swapHappen = true;
                    }
                }  
                if(!swapHappen)
                {
                    break;
                }
            }  
            
            return String.valueOf(arr); 
        }
        else
        {
            return "no answer";
        }
        
        
    }

    private static Scanner scanner = null;

    static {
        try {
            scanner = new Scanner(new File("FILE_PATH_TO_INPUT_FILE"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("FILE_PATH_TO_SAVE_THE_RESULT");


        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            fw.write(result);
            fw.write(String.format("%n"));
        }

        fw.close();

        scanner.close();
    }
}

import java.util.*;
import java.io.*;

public class P4
{
    static int a[];
    static int n;
    static boolean flag = true;
    
    public static void quickSort(int a[],int low,int high)
    {
        int i = low,j = high;
        int temp;
        int pivot = a[(low+high)/2];
        
        if(flag)
        {
            while(i<=j)
            {
                while(a[i]<pivot)
                    i++;
                while(a[j]>pivot)
                    j--;
                if(i<=j)
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i++;
                    j--;
                }
            }
            if(low<j)
                quickSort(a,low,j);
            if(i<high)
                quickSort(a,i,high);
        }
        else
        {
            while(i<=j)
            {
                while(a[i]>pivot)
                    i++;
                while(a[j]<pivot)
                    j--;
                if(i<=j)
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i++;
                    j--;
                }
            }
            if(low<j)
                quickSort(a,low,j);
            if(i<high)
                quickSort(a,i,high);
        }
    }
    
    public static void main(String args[])throws IOException
    {
        int i;
        long st,et;
        Scanner read = new Scanner(System.in);
        Random random = new Random();
        
        PrintWriter outR = new PrintWriter(new File("Random_P4.txt"));
        System.out.println("Enter the number of elements(>5000)");
        n = read.nextInt();
        a = new int[n];
        
        for(i=0;i<n;i++)
        {
            a[i] = random.nextInt(n)+1;
            outR.print(a[i]+"\t");
        }
        System.out.println("The total numbers generated: "+i);
        outR.close();
        
        st = System.nanoTime();
        quickSort(a,0,n-1);
        et = System.nanoTime()-st;
        PrintWriter outA = new PrintWriter(new File("Ascending_P4.txt"));
        for(i=0;i<n;i++)
            outA.print(a[i]+"\t");
        outA.close();
        System.out.println("THE TIME COMPLEXITY FOR WORST CASE IS= "+(et/1000000000.0)+" secs");
        
        st = System.nanoTime();
        quickSort(a,0,n-1);
        et = System.nanoTime()-st;
        System.out.println("THE TIME COMPLEXITY FOR BEST CASE IS= "+(et/1000000000.0)+" secs");
        
        flag = false;
        st = System.nanoTime();
        quickSort(a,0,n-1);
        et = System.nanoTime()-st;
        PrintWriter outD = new PrintWriter(new File("Descending_P4.txt"));
        for(i=0;i<n;i++)
            outD.print(a[i]+"\t");
        outD.close();
        System.out.println("THE TIME COMPLEXITY FOR AVERAGE CASE IS= "+(et/1000000000.0)+" secs");
    }
}

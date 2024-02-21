import java.io.File; 
public class yaml  
{ 
     static void absolutePathToFile(File[] arr,int index,int level)  
     { 
         String filename;
         if(index == arr.length) 
             return; 

         if(arr[index].isFile()) 
         {
             for (int i = 0; i < level; i++) 
                 System.out.print("    "); 

             filename = arr[index].getName();
             System.out.println("- title: "+ filename);

             for (int i = 0; i < level; i++) 
                 System.out.print("    "); 

             System.out.println("  path: /"+ filename);
         } 
         else if(arr[index].isDirectory()) 
         { 
             filename = arr[index].getName();
             for (int i = 0; i < level; i++) 
                 System.out.print("    ");
             System.out.println("- title: " + filename); 

             for (int i = 0; i < level; i++) 
                 System.out.print("    ");
             System.out.println("  items: ");
             absolutePathToFile(arr[index].listFiles(), 0, level + 1); 
         } 
         absolutePathToFile(arr,++index, level); 
    } 

    public static void main(String[] args) 
    {    
        String maindirpath = "E:\\Research\\archive\\"; 
        File maindir = new File(maindirpath); 

        if(maindir.exists() && maindir.isDirectory()) 
        { 
            File arr[] = maindir.listFiles(); 
            absolutePathToFile(arr,0,0);  
       }  
    } 
}
package testing1;


import java.io.*; 
import java.awt.Color;
import java.awt.image.*; 
import java.awt.Color.*;

import javax.imageio.*; 

public class Fuzzyblend  
{ 
  public static void main(String[] args)  
  { 
     System.out.println("Blending two JPG photos using radial pattern synthesis"); 
       //BLENDING TWO IMAGES USING RADIAL PATTERN NOTE************* THEY ARE NOT FUZZY. FUZZY IS IN FUZZYIMGTEST///////
     
      int x_res, y_res;   // Image resolution 
      int  x_c, y_c;  	  // Ring center coordinates 
      int  white; // Predefined black and white RGB representations. packed as integers
      int  i, j;   // Loop variables - indices of the current row and column 
      final int w = 10; // Fixed ring width 
      
      white=int2RGB(255,255,255);
     
      BufferedImage img=null;//, img2=null;
      File f=null;
      
      try{
          f = new File("view.jpg");
          img = ImageIO.read(f);
        }catch(IOException e){
          System.out.println(e);
        }
   
      
      x_res = Integer.parseInt( args[0].trim() ); 
      y_res = Integer.parseInt( args[1].trim() ); 
      
      x_c = x_res / 2; 		// Find coordinates of the image center 
      y_c = y_res / 2;
         
      for ( i = 0; i < y_res; i++) 
         for ( j = 0; j < x_res; j++)    
        { 
           double dist; 
           int r;
           
           dist = Math.sqrt( (i-y_c)*(i-y_c) + (j-x_c)*(j-x_c) );  //distance to center of img
           r =(int) (128*(Math.sin((Math.PI*dist)/(w*8))+1)); // Find the ring index
         
           if(r>128){
        	  
        	  img.setRGB(j,i,white); 
          } 
           int p=img.getRGB(j, i);
           
       }   

       try  
       { 
          ImageIO.write( img , "bmp", new File( args[2]) ); 
          System.out.println( "Ring image created successfully");   
       } 
       catch (IOException e) 
       { 
          System.out.println( "The image cannot be stored" );   
       } 
  }
 
  static int int2RGB( int red, int green, int blue) 
  { 
     red   = red   & 0x000000FF; 
     green = green & 0x000000FF; 
     blue  = blue  & 0x000000FF; 
     return (red << 16) + (green << 8) + blue; 
  }   
} 


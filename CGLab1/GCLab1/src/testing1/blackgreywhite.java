package testing1;


import java.io.*; 
import java.awt.image.*; 

import javax.imageio.*; 

public class blackgreywhite
{ 
  public static void main(String[] args)  
  { 
     System.out.println("Ring pattern synthesis"); 
       
      BufferedImage  img; 
      
      int x_res, y_res;   // Image resolution 
      int  x_c, y_c;  	  // Ring center coordinates 
      int  black, white; // Predefined black and white RGB representations. packed as integers
      int  i, j;   // Loop variables - indices of the current row and column 
      final int w = 10; // Fixed ring width 
      black = int2RGB( 0, 0, 0 ); 
      white = int2RGB( 255, 255, 255 ); 
     
      
      x_res = Integer.parseInt( args[0].trim() ); 
      y_res = Integer.parseInt( args[1].trim() ); 
      
      x_c = x_res / 2; 		// Find coordinates of the image center 
      y_c = y_res / 2;
      img = new BufferedImage( x_res, y_res,BufferedImage.TYPE_INT_RGB);
         
      for ( i = 0; i < y_res; i++) 
         for ( j = 0; j < x_res; j++)    
        { 
           double k,d; 
           int col,fin;
           int dis=160;
           k=255/160;
           
           d = Math.sqrt( (i-y_c)*(i-y_c) + (j-x_c)*(j-x_c) );  //distance to center of img     
           
         
           if(d>320){
        	  img.setRGB(j,i,white);
          }
           if(d<160){
        	   img.setRGB(j,i,black);
           }
           else {
        	   d=d-dis;
        	   d=d*k;
        	   col=(int) d;
        	   fin=int2RGB(col,col,col);
        	   img.setRGB(j,i,fin);
           }
       }   
   
       // Save the created image in a graphics file 
       try  
       { 
          ImageIO.write( img, "bmp", new File( args[2]) ); 
          System.out.println( "Ring image created successfully");   
       } 
       catch (IOException e) 
       { 
          System.out.println( "The image cannot be stored" );   
       } 
  } 
 
  // This method assembles RGB color intensities into single  
  // packed integer. Arguments must be in <0..255> range 
  static int int2RGB( int red, int green, int blue) 
  { 
     // Make sure that color intensities are in 0..255 range  
     red   = red   & 0x000000FF; 
     green = green & 0x000000FF; 
     blue  = blue  & 0x000000FF; 
 
     // Assemble packed RGB using bit shift operations 
     return (red << 16) + (green << 8) + blue; 
  }   
} 


package testing1;


import java.io.*; 
import java.awt.image.*; 

import javax.imageio.*; 

public class Demo1  
{ 
  public static void main(String[] args)  
  { 
     System.out.println("Fuzzy Ring pattern synthesis"); 
       
      BufferedImage  image; 
      
      int x_res, y_res;   // Image resolution 
      int  x_c, y_c;  	  // Ring center coordinates 
      int  black, white; // Predefined black and white RGB representations. packed as integers
      int  i, j;   // Loop variables - indices of the current row and column 
      final int w = 10; // Fixed ring width 
     
      x_res = Integer.parseInt( args[0].trim() ); // Get required image resolution from command line arguments 
      y_res = Integer.parseInt( args[1].trim() ); 
      
      image = new BufferedImage( x_res, y_res,BufferedImage.TYPE_INT_RGB);  // Initialize an empty image, use pixel format with RGB packed in the integer data type        

      black = int2RGB( 0, 0, 0 ); 		// Create packed RGB representation of black and white colors 
      white = int2RGB( 255, 255, 255 ); 
         
      x_c = x_res / 2; 		// Find coordinates of the image center 
      y_c = y_res / 2; 
         
      for ( i = 0; i < y_res; i++) 
         for ( j = 0; j < x_res; j++)    
        { 
           double d; 
           int r,col; 
       
           d = Math.sqrt( (i-y_c)*(i-y_c) + (j-x_c)*(j-x_c) );  //distance to center of img
           r =(int) (128*(Math.sin((Math.PI*d)/w)+1)); // Find the ring index
          if(r>255){
        	  r=255;
          }
          col=int2RGB(r,r,r);
        	  image.setRGB( j, i, col ); 		// Even ring - set black color 
                      
       }   
   
       // Save the created image in a graphics file 
       try  
       { 
          ImageIO.write( image, "bmp", new File( args[2]) ); 
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


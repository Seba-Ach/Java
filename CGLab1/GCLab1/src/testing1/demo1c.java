package testing1;


import java.io.*; 
import java.awt.image.*; 

import javax.imageio.*; 

public class demo1c
{ 
  public static void main(String[] args)  
  { 
     System.out.println("Grid pattern synthesis"); 
       
      BufferedImage  image;
      
      int x_res, y_res;   // Image resolution 
   
      int  i, j;   // Loop variables - indices of the current row and column 
      int colback, colline, colfin;
      int dxln, dyln, dxbk, dybk;
      
      x_res = Integer.parseInt( args[0].trim() ); // Get required image resolution from command line arguments 
      y_res = Integer.parseInt( args[1].trim() );
      
      dxln=Integer.parseInt( args[3].trim() ); //get required arguments for dxline length
      dyln=Integer.parseInt( args[4].trim() );
      dxbk=Integer.parseInt( args[5].trim() );
      dybk=Integer.parseInt( args[6].trim() );
     
      x_res = Integer.parseInt( args[0].trim() ); // Get required image resolution from command line arguments 
      y_res = Integer.parseInt( args[1].trim() ); 
      
      int distx=0, disty=0;
      boolean xtake=true;
      boolean isyline=false;
      boolean isybk=true;
      
      image = new BufferedImage( x_res, y_res,BufferedImage.TYPE_INT_RGB);  // Initialize an empty image, use pixel format with RGB packed in the integer data type        
 
      colback = int2RGB(255,255,255);
      colline = int2RGB(0,0,0);
      colfin=int2RGB(0,0,0);
      
         
      for ( i = 0; i < y_res; i++){ 
    	 distx=0;
    	 boolean isxline=false;
    	 boolean isxbk=true;
      
         for ( j = 0; j < x_res; j++)    
        { 	 
        	//int ipri;
        	
        	 if(distx==dxbk & isxbk  & xtake) // once we travel x distance of background we change to black;
             {
        		 colfin=colback;
        		// image.setRGB( j, i, colback );
                 distx=0;// reset distance counter.
                 isxbk=false;
                 isxline=true;
             }

        	 if(distx==dxln & xtake & isxline) // once we travel x distance of line(column) we change to background color;
             {
            	 colfin=colline;
        		 //image.setRGB( j, i, colline );
                 distx=0;
                 isxline=false;
                 isxbk=true;
             }
             
			/* int ampl=10;
        	 d = Math.sqrt( (i-y_c)*(i-y_c) + (j-x_c)*(j-x_c) );  //distance to center of img
        	 r = (int)(ampl*(Math.sin(((Math.PI*j))/(w*(33)))));
            
             ipri=i+r; */
             
        	if(disty==dybk & isybk) // once we travel y distance of background we change to black;
             {
            	 colfin=colback;
        		 //image.setRGB( j, i, colback );
                 disty=0;// reset distance counter.
                 isybk=false;
                 isyline=true;
                 xtake=false;
             }

        	 if(disty==dyln & isyline) // once we travel y distance of line(column) we change to background color;
             {
            	 colfin=colline;
        		 //image.setRGB( j, i, colline );
                 disty=0;
                 isyline=false;
                 isybk=true;
                 xtake=true;
             } 
        	/* if(ipri<0)
        		 ipri=0;
        	 if(ipri>=y_res)
        		 ipri=y_res-1; */
        	 image.setRGB(j,i,colfin); 
             
             distx++;
           					// Make decision on the pixel color based on the ring index	
       }   
         disty++;
      }
       // Save the created image in a graphics file 
       try  
       { 
          ImageIO.write( image, "bmp", new File( args[2]) ); 
          System.out.println( "Grid image created successfully");   
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



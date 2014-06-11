/* This extension of trick is meant to give exposure and practice to tricks regarding
 * conversions. All conversions here will be exact, as another file will be made to
 * implement approximated conversions. Updated by Vishnu Iyer.
 */
 
 public class Conversions
 {
   @Override
   public String [] tL()
   {
     String [] t = new String [3];
     String str1 = "";   // first conversion units
     String str2 = "";   // second conversion units
     /* integer a will be to select the type of measurement desired at random.
      * 0 will be volume, 1 will be short length, and 2 will be long length
      */
     int a = (int)(Math.random()*3);
     /* integer b will signify amount of conversions in the selected type
      * volume will have fl oz, cups, pints, quarts, gallons, pecks and bushels
      * short length will have inches, feet, and yards
      * long length will have rods, miles, and furlongs
      */
     int b = 3;
     if (a == 0)
     {
       b = 7;
     }
     int c = (int)(Math.random()*b);
     int d = -1;
     boolean cont = false;
     while (!cont)
     {
       d = (int)(Math.random()*b);
       cont = d != c;
     }
     switch (a)
     {
       case 0:
         switch(c)
         {
           case 0:
             str1 = "fl oz"
             break;
           case 1:
             str1 = "cups"
             break;
           case 2:
             str1 = "pints"
             break;
           case 3:
             str1 = "quarts"
             break;
           case 4:
             str1 = "gallons"
             break;
           case 5:
             str1 = "pecks"
             break;
           case 6:
             str1 = "bushels"
             break;
         }
         switch(d)
         {
           case 0:
             str2 = "fl oz"
             break;
           case 1:
             str2 = "cups"
             break;
           case 2:
             str2 = "pints"
             break;
           case 3:
             str2 = "quarts"
             break;
           case 4:
             str2 = "gallons"
             break;
           case 5:
             str2 = "pecks"
             break;
           case 6:
             str2 = "bushels"
             break;
         }
         break;
       case 1:
         break;
       case 2:
         break;
     }
   }
 }

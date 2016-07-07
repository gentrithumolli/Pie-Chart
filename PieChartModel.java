import java.awt.*;
import java.lang.reflect.Field;
/**Models the data of the application*/
public class PieChartModel
{  /**Converts a string to a color*/
   public static Color stringToColor(final String value) {
      if (value == null) {
         return Color.black;
      }
      {
      
         try {
         
            final Field f = Color.class.getField(value);
         
            return (Color) f.get(null);
         } 
         catch (Exception ce) {
         
            return Color.black;
         }
      }
   }
   /**Calculates the angle of each slice in the piecha*/
   public static int angle(int amount, int total)
   {
      int angle =  (int)(Math.round((360.0/total)*amount));
      return angle;
   }
  
}
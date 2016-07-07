import javax.swing.*;
/**Receives the input given from the user*/
public class PieChartInput
{  
   private int amount;
   private String scolor;
   private int i = 0;
   public String getTheData()
   { 
     String input = JOptionPane.showInputDialog("Write the data for slice " + (i+1) );
     i++;
     /*Creates and array of three values(label, amount and color), by separating the input taken 
           from the dialog created by the line above, using comma as a reference 
           and removing the space after the comma.*/
     String[] Array = input.split(",[ ]*");
     String label = Array[0];
     amount = new Integer(Array[1]).intValue();
     scolor = Array[2];
     return label;
   }
   /**Constructs a dialog where the user can write the title of the piechart*/
   public String title()
   {
      return JOptionPane.showInputDialog("Write the title of the piechart");
   }
   /**Returns the string is a name for a color*/
   public String color()
   {
      return scolor;
   }
   /**Returns the amount given by the user*/
   public int amount()
   {
      return amount;
   }
   
   
   
   public int nrOfSlices()
   {
      int n = new Integer(JOptionPane.showInputDialog("Write the number of slices: ")).intValue();
      return n;
   }
   
   
}
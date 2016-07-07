import java.awt.*;
public class PieChartController
{
   public static void main(String[] args)
   {
      PieChartInput input = new PieChartInput();
      int n = input.nrOfSlices();
      String title = input.title();
      PieChartOutput output = new PieChartOutput(n, title);
      for(int i = 0; i<n; i++ )
         {
            String label = input.getTheData();
            int  amount = input.amount();
            String c = input.color();
            Color color = PieChartModel.stringToColor(c);
            output.setSlice(label, amount, color);   
         }
   }
}
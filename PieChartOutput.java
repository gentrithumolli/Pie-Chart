import javax.swing.*;
import java.awt.*;
/**Draws the piechart*/
public class PieChartOutput extends JPanel
{  
   private int n;
   private int count = 0;
   private int total;
   JFrame frame;
   private int left_edge = 30;
   private int top = 30;
   private int diameter = 180;
   private int frame_width = 600;
   private int frame_height = diameter+(2*top)+20;
   private int stringX = left_edge*2 + diameter + 15;
   private int stringY = top + 40;
   private int line_space = 15;
   private String[] labels;
   private int[] amounts;
   private Color[] colors;

   /**Creates the frame and inserts the panel to the created frame*/
   public PieChartOutput(int number, String title)
   {
      n = number;
      labels = new String[n];
      amounts = new int[n];
      colors = new Color[n];
      frame = new JFrame();
      frame.getContentPane().add(this);
      frame.setSize(frame_width, frame_height);
      frame.setTitle(title);
      frame.setVisible(true);
   }
   /**Draws the piechart*/
   public void paintComponent(Graphics g)
   {  if(count == n){
      g.setColor(Color.white);
      g.fillRect(0,0,frame_width,frame_height);
      //draws the first slice
      g.setColor(colors[0]);
      g.drawOval(left_edge,top,diameter,diameter);
      g.fillArc(left_edge,top,diameter,diameter,0,PieChartModel.angle(amounts[0],total));
      g.drawString(labels[0],stringX,stringY );
      g.fillRect(stringX-10,stringY-8,8,8);
      
      //draws the other slices
      int startAngle = 0;
      for(int i = 1; i < n; i++){  
        startAngle = startAngle + PieChartModel.angle(amounts[i-1],total);//Starting angle for each of the slices
        g.setColor(colors[i]);
        g.fillArc(left_edge,top,diameter,diameter,startAngle,PieChartModel.angle(amounts[i],total));
        g.drawString(labels[i],stringX,stringY+i*line_space );
        g.fillRect(stringX-10,stringY-8+i*line_space,8,8);
        }}
      
    }
   /**Fills the arrays with the values of the local parameters*/
   public void setSlice(String label, int amount, Color c)
   {
      labels[count] = label;
      amounts[count] = amount;
      colors[count] = c;
      total = total + amount;
      count++;
      this.repaint();
   }
   
   
}
import java.math.*;
public class EField {
   public final double EPSILON_NOUGHT = (Math.pow(8.8541878128, -13));
   public final double K = (1/(4 * Math.PI * EPSILON_NOUGHT));
   
   public static void main(String[] args) {
   
   PointCharge charge1 = new PointCharge(1,2,3,-3);
   PointCharge charge2 = new PointCharge(-2,-2,-3,-5);
   PointCharge charge3 = new PointCharge(-3,-3,-3,-3);
   
   
   }
/*
   public BigDecimal getElectricPotential(int xCoord,int yCoord, int zCoord) {
   }   
*/
   public double getElectricField(int xCoord,int yCoord, int zCoord, PointCharge charge) {
      int xDist = Math.abs(xCoord - charge.getXCoord());
      int yDist = Math.abs(yCoord - charge.getYCoord());
      int zDist = Math.abs(zCoord - charge.getZCoord());
      double dist = Math.sqrt(Math.pow(xDist,2) + Math.pow(yDist,2) + Math.pow(zDist,2));
      
      
      double answer = K * charge.getCharge() / dist;
      return answer;
      
   }
}
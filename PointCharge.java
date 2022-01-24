import java.math.*;
public class PointCharge {

   private int charge = 1;
   private int xCoord = 0;
   private int yCoord = 0;
   private int zCoord = 0;
   
   public PointCharge(int charge, int xCoord, int yCoord, int zCoord) {
      this.charge = charge;
      this.xCoord = xCoord;
      this.yCoord = yCoord;
      this.zCoord = zCoord;
   }

   public int getCharge() {
      return charge;
   }
   public int getXCoord() {
      return this.xCoord;
   }
   public int getYCoord() {
      return this.yCoord;
   }
   public int getZCoord() {
      return this.yCoord;
   }
   public BigDecimal getDistance() {
      BigDecimal answer = new BigDecimal(Double.toString(Math.sqrt(Math.pow(xCoord,2) + Math.pow(yCoord,2) + Math.pow(zCoord,2))));
      
      return answer;
   }
   public String toString() {
      String output = "Charge: " + this.charge;
      output += "\nXCoord: " + this.xCoord;
      output += "\nYCoord: " + this.yCoord;
      output += "\nZCoord: " + this.zCoord;
      return output;
   }
}
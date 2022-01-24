import java.math.*;
public class EField {
   public static final double EPSILON_NOUGHT = (Math.pow(8.8541878128, -13));
   public static final double K = (1/(4 * Math.PI * EPSILON_NOUGHT));
   
   public static void main(String[] args) {
      double[] finalElectricField = {0,0,0};
      PointCharge charge1 = new PointCharge(1,2,3,-3);
      PointCharge charge2 = new PointCharge(-2,-2,-3,-5);
      PointCharge charge3 = new PointCharge(-3,-3,-3,-3);
      
      PointCharge[] charges = {charge1,charge2,charge3};
      double[][] electricFields = new double[charges.length][3];
      for(int i = 0; i < charges.length; i++) {
         electricFields[i] = getElectricField(-2,4,5,charges[i]);
      }
      
      for(double[] eField : electricFields) {
         for(int i = 0; i < finalElectricField.length; i++) {
            finalElectricField[i] += eField[i];
         }
      }
      System.out.println(finalElectricField[0]);
      System.out.println(finalElectricField[1]);
      System.out.println(finalElectricField[2]);
   }

   public static double[] getElectricField(int xCoord,int yCoord, int zCoord, PointCharge charge) {
      int chargeVal = charge.getCharge();
      double[] eField = {0,0,0};
      int xDist = Math.abs(xCoord - charge.getXCoord());
      int yDist = Math.abs(yCoord - charge.getYCoord());
      int zDist = Math.abs(zCoord - charge.getZCoord());
      double dist = Math.sqrt(Math.pow(xDist,2) + Math.pow(yDist,2) + Math.pow(zDist,2));
      
      double[] vector = {chargeVal * xDist,chargeVal * yDist,chargeVal * zDist};
       
      for(int i = 0; i < eField.length; i++) {    
         eField[i] = K*vector[i]/Math.pow(dist,3);
      }
      
      return eField;
   }
}
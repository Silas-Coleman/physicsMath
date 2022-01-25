import java.util.*;
import java.math.*;
public class EField {
   public static final double EPSILON_NOUGHT = (Math.pow(8.8541878128, -13));
   public static final double K = (1/(4 * Math.PI * EPSILON_NOUGHT));
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      boolean adding = true;
      ArrayList<PointCharge> pointCharges = new ArrayList<PointCharge>();
      while(adding){
         System.out.println("What is the charge of the point charge in Coulombs (Please enter an integer)?");
         int charge = Integer.valueOf(in.next());
         System.out.println("What is the point charge's X Coorddinate (Please enter an integer)?");
         int xCoord = Integer.valueOf(in.next());
         System.out.println("What is the point charge's Y Coorddinate (Please enter an integer)?");
         int yCoord = Integer.valueOf(in.next());
         System.out.println("What is the point charge's Z Coorddinate (Please enter an integer)?");
         int zCoord = Integer.valueOf(in.next());
         PointCharge pointCharge = new PointCharge(charge,xCoord,yCoord,zCoord);
         pointCharges.add(pointCharge);
         System.out.println("Please type \"Done\" to stop adding point charges. Else hit enter.");
         if(in.next().equalsIgnoreCase("Done")) adding = false;
         else continue; 
      }
         System.out.println("What is the location you want the EField's X Coorddinate (Please enter an integer)?");
         int xCoord = Integer.valueOf(in.next());
         System.out.println("What is the location you want the EField's Y Coorddinate (Please enter an integer)?");
         int yCoord = Integer.valueOf(in.next());
         System.out.println("What is the location you want the EField's Z Coorddinate (Please enter an integer)?");
         int zCoord = Integer.valueOf(in.next());
      
      
      double[] finalElectricField = {0,0,0};
      double[][] electricFields = new double[pointCharges.size()][3];
      for(int i = 0; i < pointCharges.size(); i++) {
         electricFields[i] = getElectricField(xCoord,yCoord,zCoord,pointCharges.get(i));
      }
      
      for(double[] eField : electricFields) {
         for(int i = 0; i < finalElectricField.length; i++) {
            finalElectricField[i] += eField[i];
         }
      }
      System.out.println("<" + finalElectricField[0] + ", ");
      System.out.print(finalElectricField[1] + ", ");
      System.out.print(finalElectricField[2] + ">");
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
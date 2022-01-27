import java.util.*;
import java.math.*;
public class EField {
   public static final double EPSILON_NOUGHT = (Math.pow(8.8541878128, -13));
   public static final double K = (1/(4 * Math.PI * EPSILON_NOUGHT));
   
   public static void main(String[] args) {
      //Scanner Setup for I/O
      Scanner in = new Scanner(System.in);
      //User Input System to get Array List of Point Charges and Place to calculate EField
      boolean adding = true;
      ArrayList<PointCharge> pointCharges = new ArrayList<PointCharge>();
         //Gets Point Charges
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
         System.out.println("Please type \"Done\" to stop adding point charges. Else type any character and hit enter.");
         if(in.next().equalsIgnoreCase("Done")) adding = false;
         else continue; 
      }
         //Gets EField Spot
      System.out.println("What is the location you want the EField's X Coorddinate (Please enter an integer)?");
      int xCoord = Integer.valueOf(in.next());
      System.out.println("What is the location you want the EField's Y Coorddinate (Please enter an integer)?");
      int yCoord = Integer.valueOf(in.next());
      System.out.println("What is the location you want the EField's Z Coorddinate (Please enter an integer)?");
      int zCoord = Integer.valueOf(in.next());
      
      //System for Adding all EFields from point charges due to Superposition
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
      //Printing the Array in Vector Format
      System.out.println("<" + finalElectricField[0] + ", ");
      System.out.print(finalElectricField[1] + ", ");
      System.out.print(finalElectricField[2] + ">");
   }
   //Takes xCoord, yCoord, and zCoord of EField Spot and Point charge to calculate the EField at a point in space due to a certain charge
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
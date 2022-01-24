import java.math.*;
public class PointCharge {

   private BigDecimal charge = new BigDecimal("1");
   private BigDecimal xCoord = new BigDecimal("0");
   private BigDecimal yCoord = new BigDecimal("0");
   private BigDecimal zCoord = new BigDecimal("0");
   
   public PointCharge(BigDecimal charge, BigDecimal xCoord, BigDecimal yCoord, BigDecimal zCoord) {
      this.charge = new BigDecimal(charge.toString());
      this.xCoord = new BigDecimal(xCoord.toString());
      this.yCoord = new BigDecimal(yCoord.toString());
      this.zCoord = new BigDecimal(zCoord.toString());
   }

   public BigDecimal getCharge() {
      return this.charge;
   }
   public BigDecimal getXCoord() {
      return this.xCoord;
   }
   public BigDecimal getYCoord() {
      return this.yCoord;
   }
   public BigDecimal getZCoord() {
      return this.yCoord;
   }
}
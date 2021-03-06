package org.mycompany.util;



public class ConvertAngle extends ConvertUnits {
  public final int DEGREES 	 	= 0;
  public final int RADIANS  	= 1;
  public final int PER_DEGREES  = 2;
  public final int PER_RADIANS  = 3;
  
  final String []  m_rgsUnitsNames      = {
    "deg", "rad" ,"1/deg", "1/rad"
  };

  public int numberOfUnitNames() {
    return m_rgsUnitsNames.length;
  }  // End of method numberOfUnitNames

  public String unitName(int nIndex) {
    String sName = "";
    if(nIndex >= 0 && nIndex < numberOfUnitNames()) {
      sName = m_rgsUnitsNames[nIndex];
    }  // End of if statement.
    return sName;
  }  // End of method unitName

  public double convert(double dAngle, int nOldUnitsID, int nNewUnitsID) {
    double dConverted = dAngle;

    //convert old value into degrees.
    switch (nOldUnitsID) {
      case DEGREES: {
        if(isPerUnits(nNewUnitsID)) {
          dConverted = Double.NaN;
        }  
        break;        
      } 
      case RADIANS: {
        if(isPerUnits(nNewUnitsID)) {
          dConverted = Double.NaN;
        }
        else {
          dConverted *= 180.0 / Math.PI;
        }  // End of else statement.
        break;
      }  
    }  

    if(!Double.isNaN(dConverted)) {
      switch (nNewUnitsID) {
        case DEGREES: {
          if (isPerUnits(nOldUnitsID)) {
            dConverted = Double.NaN;
          } // End of else statement.
          break;
        } // End of case statement.

        case RADIANS: {
          if (isPerUnits(nOldUnitsID)) {
            dConverted = Double.NaN;
          }
          else {
            dConverted *= Math.PI / 180.0;
          } 
          break;
        } 
      } 
    }  

    return dConverted;
  }  // End of method convert

  private boolean isPerUnits(int nUnitCode) {
    return nUnitCode == PER_DEGREES || nUnitCode == PER_RADIANS;
  }  // End of method isPerUnits
}  // End of ConvertDistance

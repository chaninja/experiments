package org.mycompany.util;

public abstract class ConvertUnits {
  abstract public double convert(double dValue, int nOldUnitsID, int nNewUnitsID);

  abstract public int numberOfUnitNames();

  abstract public String unitName(int nIndex);

  public int unitsCode(String sUnits) {
    int nCode = -1;
    if(sUnits != null) {
      for (int i = 0; i < numberOfUnitNames() && nCode < 0; i++) {
        if (sUnits.toLowerCase().matches("(\\x28)?(" + unitName(i).toLowerCase() + "){1}(\\x29)?")) {
          nCode = i;
        } // End of if statement.
      } // End of for loop
    }  // End of if statement.
    return nCode;
  }

  public String enclosedUnits(int nUnitsCode) {
    String sUnits = unitName(nUnitsCode);
    return sUnits.length() > 0 ? "(" + sUnits + ")" : "";
  }
} 

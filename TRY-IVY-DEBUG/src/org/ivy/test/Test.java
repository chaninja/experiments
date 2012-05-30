package org.ivy.test;

import java.io.IOException;

import org.mycompany.util.ConvertAngle;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ConvertAngle ca = new ConvertAngle();
		double newAngle = ca.convert(35, 0, 1);
	}

}

package com.mycompany.supermarket;

import java.io.*;
import java.util.*;


public class WriteTextFile {
    
	private Formatter ou;

	public void openFile(String fileName) {
		try {
			ou = new Formatter(fileName);
		} catch (SecurityException ex) {
			System.err.println("You do not have write access to this file.");

		} catch (FileNotFoundException ex) {
			System.err.println("Error opening or creating file.");

		}
	}
	public void WriteFile(Product p) {

		try {
			ou.format( p.toString() + "\n");
		} catch (FormatterClosedException ex) {
			System.err.println("Error writing to file");
		}
	}

	public void CloseFile() {
		if (ou != null) {
			ou.close();
		}
	}
}
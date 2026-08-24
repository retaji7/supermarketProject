
package com.mycompany.supermarket;


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class ReadTextFile {
	private Scanner in;

	public void openFile(String fileName) {
		try {
			in = new Scanner(new File(fileName));
		} catch (FileNotFoundException ex) {
			System.err.println("Error opening or creating file.");
		}
	}
        
	public void ReadFile() {
		try {
			while (in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
		} catch (NoSuchElementException ex) {
			System.err.println("File improperly formed.");
			in.close();
		} catch (IllegalStateException ex) {
			System.err.println("Error reading from file.");
                        System.exit(1);
		}
	}

	public void CloseFile() {
		if (in != null) {
			in.close();
		}
	}
}
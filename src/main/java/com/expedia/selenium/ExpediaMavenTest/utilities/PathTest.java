package com.expedia.selenium.ExpediaMavenTest.utilities;

import java.io.File;
import java.io.IOException;

public class PathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File path = new File("screenshot").getAbsoluteFile();
		File path2 = new File("").getParentFile();
		System.out.println(path2);
		System.out.println(path);
		

	}

}

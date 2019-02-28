import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Slideshow {
	
	public static void main(String[] args) {
		
		Scanner sc;
		try {
			sc = new Scanner(new File("C:\\Users\\F\\Documents\\HashCode-2019\\b_lovely_landscapes.txt"));
		
		
		
		int numPhotos = Integer.parseInt(sc.nextLine());
		String[][] photos = new String[numPhotos][100];
		int count = 0;
		while(sc.hasNextLine()) {
			String[] line = sc.nextLine().split(" ");
			
			for(int i=0; i<line.length-1;i++) {
				photos[count][i] = line[i+1];
			}
			
			count++;
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\F\\Documents\\HashCode-2019\\submission.txt"));
			bw.write(numPhotos);
			for(int i=0;i<numPhotos;i++) {
				bw.write(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

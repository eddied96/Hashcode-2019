import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Slideshow {
	
	public static void main(String[] args) {
		
		Scanner sc;
		try {
			sc = new Scanner(new File("C:\\Users\\F\\Documents\\HashCode-2019\\b_lovely_landscapes.txt"));
		
		
		
		int numPhotos = Integer.parseInt(sc.nextLine());
		ArrayList<List<String>> photos = new ArrayList<List<String>>();
		int count = 0;
		while(sc.hasNextLine()) {
			photos.add(Arrays.asList(sc.nextLine().split(" ")));
			
			count++;
		}
		
		int slideCount = 0;
		int[] slides = new int[numPhotos];
		
		slides[0] = 1;
		slideCount++;
		List<String> currentPhoto = new ArrayList<String> ();
		currentPhoto = photos.get(0);
		photos.remove(0);
		
		int numMatches = 0;
		int nextPhoto = 0;
		int currentTag = 0;
		while (!photos.isEmpty()) {
			if(Collections.binarySearch(photos.get(nextPhoto), currentPhoto.get(currentTag)) != -1) {
				numMatches++;
			}
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\F\\Documents\\HashCode-2019\\submission.txt"));
			bw.write(Integer.toString(numPhotos) + "\n");
			for(int i=0;i<numPhotos;i++) {
				bw.write(Integer.toString(i) + "\n");
				bw.flush();
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

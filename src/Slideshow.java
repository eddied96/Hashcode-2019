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
		ArrayList<List<String>> photos2 = new ArrayList<List<String>>();
		int count = 0;
		while(sc.hasNextLine()) {
			ArrayList<String> line = new ArrayList<String>();
			line.addAll(Arrays.asList(sc.nextLine().split(" ")));
			line.remove(0);
			line.remove(0);
			Collections.sort(line);
			photos.add(line);
			photos2.add(line);
			
			count++;
		}
		
		int slideCount = 0;
		int[] slides = new int[numPhotos];
		
		Collections.shuffle(photos);
		slides[0] = 1;
		slideCount++;
		List<String> currentPhoto = new ArrayList<String> ();
		currentPhoto = photos.get(1);
		photos.remove(1);
		
		int nextPhoto = 0;
		int currentTag = 0;
		boolean noMatch = false;
		while(noMatch ==false) {
			if(!photos.isEmpty()) {
				if(currentTag < currentPhoto.size()) {
					if(Collections.binarySearch(photos.get(nextPhoto), currentPhoto.get(currentTag)) > -1) {
						slides[slideCount] = photos2.indexOf(photos.get(nextPhoto));
						slideCount++;
						currentPhoto = photos.get(nextPhoto);
						photos.remove(nextPhoto);
						currentTag=0;
						nextPhoto=0;
					}else {
						currentTag++;
					}
				}
				else {
					currentTag = 0;
					nextPhoto++;
					if(nextPhoto >= photos.size()) {
						noMatch =true;
					}
				}
			}
			else {
				noMatch =true;
			}
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\F\\Documents\\HashCode-2019\\submission.txt"));
			bw.write(Integer.toString(slideCount) + "\n");
			for(int i=0;i<slideCount;i++) {
				bw.write(Integer.toString(slides[i]) + "\n");
				bw.flush();
			}
			System.out.println(slideCount);
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

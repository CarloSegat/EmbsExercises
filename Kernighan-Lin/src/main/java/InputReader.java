import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.ParseException;

import com.google.common.base.Strings;

public class InputReader {
	
	final static String inputPath = "src\\main\\java\\data.json";
	
	public ArrayList<ArrayList<Integer>> readInputRaw() throws ParseException {
		try {
			String rawFile = readFile(inputPath);
			JSONObject jsonFile = (JSONObject) JSONValue.parseWithException(rawFile);
			JSONArray array = (JSONArray) jsonFile.get("XActorYTokens");
			ArrayList<ArrayList<Integer>> actorsOnYTokensOnX = (ArrayList<ArrayList<Integer>>) array;
			return actorsOnYTokensOnX;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String readFile(String pathname) throws IOException {

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());        

	    try (Scanner scanner = new Scanner(file)) {
	        while(scanner.hasNextLine()) {
	            fileContents.append(scanner.nextLine() + System.lineSeparator());
	        }
	        return fileContents.toString();
	    }
	}

}

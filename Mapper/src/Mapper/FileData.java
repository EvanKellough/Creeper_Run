package Mapper;
import java.io.IOException;

public class FileData {
	
	public static void main(String[] args)throws IOException{
		String file_name = "/Users/Evan/Desktop/test.txt";
		
		try {
			ReadFile file = new ReadFile(file_name);
			String[] aryLines = file.OpenFile();
			
			int i;
			for (i = 0; i < aryLines.length; i++){
				System.out.println(aryLines[i]);
			}
			
		}
		catch (IOException e){
			System.out.println(e.getMessage() );
		}
		
		int x = 0; //Number of Columns
		int y = 0;  //Number of Rows
		int z = 0;
		int col = 152;
		int row = 96;
		int max = col * row;
		//int max = 14052;
		
		try{
				while(x <= max){
					if(y == col){
						WriteFile newline = new WriteFile(file_name, true);
						String line = String.valueOf(x + " ");
						newline.LineBreak(line);
						y = 0;
						x++;
					}
					WriteFile data = new WriteFile(file_name, true);
					/*
					String num1 = String.valueOf(x + " ");
					String num2 = String.valueOf(row + " ");
					data.writeToFile(num1);
					data.writeToFile(num2);
					*/
				String number = String.valueOf(x);
				data.writeToFile(number + " ");
				System.out.println(max);
				x++;
				y++;
		}
	}
				catch (IOException e){
					System.out.println(e.getMessage() );
		}
		
		
		
		/*
		//Writes a single line of numbers to File
		try{
			//WriteFile data = new WriteFile(file_name, true);
			//String num1 = String.valueOf(col + " ");
			//String num2 = String.valueOf(row + " ");
			while(y <= row){
				while(x <= col){
					WriteFile data = new WriteFile(file_name, true);
					String num1 = String.valueOf(x + " ");
					String num2 = String.valueOf(row + " ");
					data.writeToFile(num1);
					data.writeToFile(num2);
					
					if(x = col || y = row){
						//data.writeToFile(textLine);
						data.writeToFile(text);
						y++;
					}
				String number = String.valueOf(x);
				data.writeToFile(number + " ");
				System.out.println("Mission Complete");
				x++;
			}
				y++;
				System.out.println("row added");
		}
	}
				catch (IOException e){
					System.out.println(e.getMessage() );
		}
		*/
		
		
		
	}
}
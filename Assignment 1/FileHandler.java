import java.io.*;
import java.util.HashMap;
import java.nio.charset.StandardCharsets;

public class FileHandler {

    private File file;
    private RandomAccessFile raf;
	private HashMap<String, Long> hmap;
	
	/* 
		We use a Random Access File, which basically behaves as a large array of bytes,
		stored in the file system. 
		This is equipped with a cursor called a file pointer, which we can use to find the offset. 
	*/
    public FileHandler () throws IOException {
		//Creates the file we use as database
        file = new File("database.txt");
		//"rw": The file is opened in read/write mode
        raf = new RandomAccessFile(file, "rw");
        hmap = new HashMap<>();
		
    }
	/*
		Saving the key and byte offset in our hashmap and saves both the key and value
		in the database file.
    */
    public void writeFile (String key, String value){
        try{
		String data = key + ":" + value;
        byte[] byteArr = data.getBytes("UTF-8");
        hmap.put(key, raf.getFilePointer());
        raf.write(byteArr);
        raf.writeBytes(System.getProperty("line.separator"));
		}catch(IOException ex){
			System.out.println(ex);
		} 
    }
    /*
		The method for reading the file takes a string as parameter- the key. 
		We then use the raf method seek(), which takes the key and sets the file pointer equal to that key. 
		We read the line from that pointer. We use replaceAll to make sure that we only return the value
		and not the key. 
    */
    public String readFile(String key) throws IOException {
        try{
		raf.seek(hmap.get(key));
        String l = raf.readLine();  
        return l.replaceAll(".*:", "");
		}catch(NullPointerException npex){
			String err = "No result for this key";
			return err;
		}
    }
}
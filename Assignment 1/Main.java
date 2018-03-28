import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler();
        fh.writeFile("1", "Cat");
		fh.writeFile("2", "Cow");
		fh.writeFile("3", "Horse");
		fh.writeFile("52", "Dog");
        
		System.out.println(fh.readFile("52"));
    }
}
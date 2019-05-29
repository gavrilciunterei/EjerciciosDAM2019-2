import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PruebasBasicas2 {

	public static void main(String[] args) throws IOException {

		RandomAccessFile raf = new RandomAccessFile("prueba2.txt", "rw");

	//	raf.writeUTF("ola");
		
		System.out.println(raf.readUTF());
		
		
		
	}

}

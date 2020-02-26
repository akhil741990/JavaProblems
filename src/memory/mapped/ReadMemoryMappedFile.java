package memory.mapped;

import java.io.File;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class ReadMemoryMappedFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String filePath = "/home/akhil/soul-workspace/JavaProblems/Notes/mmap.txt";
		
		File f = new File(filePath);		
		
		CharBuffer charBuffer = null;
		Path pathToRead = Paths.get(filePath);
		 
		try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(
		  pathToRead, EnumSet.of(StandardOpenOption.READ))) {
		  
		    MappedByteBuffer mappedByteBuffer = fileChannel
		      .map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
		 
		    if (mappedByteBuffer != null) {
		        charBuffer = Charset.forName("UTF-8").decode(mappedByteBuffer);
		        System.out.println(charBuffer);
		    }
		}
		
	}
	

}

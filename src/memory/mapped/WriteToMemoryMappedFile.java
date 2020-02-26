package memory.mapped;

import java.io.File;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class WriteToMemoryMappedFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String filePath = "/home/akhil/soul-workspace/JavaProblems/Notes/mmap.txt";
		
		File f = new File(filePath);		
		
		Path pathToRead = Paths.get(filePath);
		CharBuffer charBuffer = CharBuffer
  			  .wrap("This will be written to the file"); 
		try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(
		  pathToRead, EnumSet.of(StandardOpenOption.READ, StandardOpenOption.WRITE))) {
		  
		    MappedByteBuffer mappedByteBuffer = fileChannel
		      .map(FileChannel.MapMode.READ_WRITE, 0, charBuffer.length());
		 
		    if (mappedByteBuffer != null) {
		    	mappedByteBuffer.put(Charset.forName("UTF-8").encode(charBuffer));
		        System.out.println("Open file " + filePath + " and verify the written contents");
		    }
		}
		
	}

}

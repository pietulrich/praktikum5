package writers;

import java.io.IOException;

public class ConcreteTxtWriterCreator extends WriterCreator {
    public WriterProduct factoryMethod() throws IOException{
    	return new ConcreteTxtWriterProduct();
    } 
}
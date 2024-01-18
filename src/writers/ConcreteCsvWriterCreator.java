package writers;

import java.io.IOException;

public class ConcreteCsvWriterCreator extends WriterCreator {
    public WriterProduct factoryMethod() throws IOException{
    	return new ConcreteCsvWriterProduct();
    } 
}

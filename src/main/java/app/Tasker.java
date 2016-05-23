package app;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * Created by V3790148 on 5/19/2016.
 */
public class Tasker implements Runnable {
    private BufferedReader br=null;
    private GZIPInputStream gzstream;
    private Reader decoder;
    private Processor processor;
    private UserRepository repository;
    public Tasker(InputStream inputStream, UserRepository repository) throws IOException{
        this.repository=repository;
        gzstream=new GZIPInputStream(inputStream);

    }

    @Override
    public void run(){
        decoder=new InputStreamReader(gzstream);
        br=new BufferedReader(decoder);
        processor=new Processor(br,repository);
        processor.Process();
    }
}

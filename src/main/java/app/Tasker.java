package app;

import app.db.DbService;

import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * Created by V3790148 on 5/19/2016.
 */
public class Tasker implements Runnable{
    private BufferedReader br=null;
    private GZIPInputStream gzstream;
    private Reader decoder;
    private Processor processor;
    private DbService repository;
    public Tasker(InputStream inputStream, DbService repository) throws IOException{
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

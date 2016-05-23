package app;

import app.userlog.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

/**
 * Created by V3790148 on 5/19/2016.
 */

public class Processor {


    DbService repository;

    private BufferedReader br;
    private Parse p;
    private String line = null;
    private User temp;

    public Processor(BufferedReader br, DbService repository) {
        this.br = br;
        this.repository = repository;
    }


    public void Process() {
        try {
            while ((line = br.readLine()) != null) {
                p = new Parse(line);
                temp = p.getUser();
                repository.save(temp);


            }
            System.out.println("Closing buffered reader");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
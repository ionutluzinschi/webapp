package app;

import app.userlog.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

/**
 * Created by V3790148 on 5/19/2016.
 */

public class Processor {


    UserRepository repository;

    private BufferedReader br;
    private Parse p;
    private String line = null;
    private User temp;


    public Processor(BufferedReader br, UserRepository repository) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
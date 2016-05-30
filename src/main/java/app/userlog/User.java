package app.userlog;

import javax.persistence.*;

import static java.lang.String.format;

/**
 * Created by V3790148 on 5/18/2016.
 */
@Entity
@Table(name="user_logs")
public class User {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="IP")
    private String ipAddress;
    @Column(name="Response",nullable = false)
    private String response;
    @Column(name="Bytes",nullable = false)
    private String bytes;

    protected User(){}

    public User(String ipAddress,String response,String bytes){
        this.ipAddress = ipAddress;
        this.response=response;
        this.bytes=bytes;
    }
    public void setIpAddress(String ipAddress){
        this.ipAddress = ipAddress;
    }

    public void setResponse(String response){
        this.response=response;
    }

    public void setBytes(String bytes){
        this.bytes=bytes;
    }
    public String getIpAddress(){
        return ipAddress;
    }

    public String getResponse(){
        return response;
    }

    public String getBytes(){
        return bytes;
    }


    @Override
    public String toString(){

        return String.format("IPAddress=%s, response=%s, bytes=%s", ipAddress,response,bytes);
    }



}

package app;

import app.db.DbService;
import app.userlog.User;

/**
 * Created by p3700657 on 5/23/2016.
 */
public class IpStats {
    private String ip;
    private long success;
    private long notFound;
    private long bytes=0;
    private DbService repository;
    public IpStats(String ip,DbService repository){
        this.repository=repository;
        this.ip=ip;

    }

    public String getStats(){
        notFound=0;
        success=0;
        bytes=0;
        for(User user:  repository.findByipAddress(ip)){
            if(user.getResponse().equalsIgnoreCase("404")){
                notFound++;}
            if(user.getResponse().equalsIgnoreCase("200")){
                success++;}
            bytes=bytes+Long.parseLong(user.getBytes());

        }

        return ip+" success="+success+" "+"notFound="+notFound+" bytes="+bytes;
    }




}

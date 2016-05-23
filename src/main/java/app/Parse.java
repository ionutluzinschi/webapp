package app;

import app.userlog.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by V3790148 on 5/18/2016.
 */
public class Parse {

    private String line;
    private String ipAddress;
    private String response;
    private String bytes;
    private String logEntryPattern = "^([\\d.]+|::\\d) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\d+).*";


    public Parse(String line){
        this.line=line;
    }

    public User getUser(){
        Pattern pattern=Pattern.compile(logEntryPattern);
        Matcher matcher=pattern.matcher(line);
        if(matcher.matches()) {
            ipAddress = matcher.group(1);
            response = matcher.group(6);
            bytes = matcher.group(7);
        }
        return new User(ipAddress,response,bytes);

    }

}

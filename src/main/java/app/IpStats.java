package app;

import app.userlog.UserLog;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * Created by p3700657 on 5/23/2016.
 */
public class IpStats {
    @JsonView(Views.Normal.class)
    private String ip;
    @JsonView(Views.Normal.class)
    private long success;
    @JsonView(Views.Normal.class)
    private long notFound;
    @JsonView(Views.Extended.class)
    private long bytes = 0;

    private DbService repository;

    public IpStats() {
    }

    public IpStats(String ip, DbService repository) {
        this.repository = repository;
        this.ip = ip;

    }

    public String getStats() {
        notFound = 0;
        success = 0;
        bytes = 0;
        for (UserLog userLog : repository.findByipAddress(ip)) {
            if (userLog.getResponse().equalsIgnoreCase("404")) {
                notFound++;
            }
            if (userLog.getResponse().equalsIgnoreCase("200")) {
                success++;
            }
            bytes = bytes + Long.parseLong(userLog.getBytes());

        }
        return ip + " success=" + success + " " + "notFound=" + notFound + " bytes=" + bytes;
    }

    public void setStats() {
        for (UserLog userLog : repository.findByipAddress(ip)) {
            if (userLog.getResponse().equalsIgnoreCase("404")) {
                notFound++;
            }
            if (userLog.getResponse().equalsIgnoreCase("200")) {
                success++;
            }
            bytes = bytes + Long.parseLong(userLog.getBytes());

        }
    }
}

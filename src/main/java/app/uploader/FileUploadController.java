package app.uploader;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import app.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
    private String name=null;

    private Tasker t;
    @Autowired
    DbService repository;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String provideUploadInfo() {
        return "uploadForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String handleFileUpload(@RequestParam("files") MultipartFile[] files) {

        ExecutorService exec= Executors.newFixedThreadPool(files.length);
        if(files!=null && files.length>0) {
            for (int i = 0; i < files.length; i++) {
                try
                {
                    t=new Tasker(files[i].getInputStream(),repository);
                    exec.submit(t);
                    name = files[i].getOriginalFilename();
                    System.out.println("Successfully uploaded "+name);
                }
                catch (Exception e) {
                    System.out.println("You failed to upload " + name + " => " + e.getMessage());
                }
            }
        }
                return "uploadForm";
    }

    @RequestMapping("/findByIP")
    @ResponseBody
    public String getStatistics(@RequestParam(value="ip") String ip){
        IpStats stats=new IpStats(ip,repository);

        if(repository.findByipAddress(ip).isEmpty()){
            return "ip not found";}
        else{
            return stats.getStats();

            }
    }








}


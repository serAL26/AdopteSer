package fr.afcepf.adopteundev.managedbean.uploadfile;

import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@ManagedBean
@SessionScoped
public class MBUploadLivrable {
    private Logger log = Logger.getLogger(MBUploadLivrable.class);
    private Part file;
    private String fileContent;

    public void upload() {
        try {
            fileContent = new Scanner(file.getInputStream())
                    .useDelimiter("\\A").next();
        } catch (IOException e) {
            // Error handling
        }
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
}

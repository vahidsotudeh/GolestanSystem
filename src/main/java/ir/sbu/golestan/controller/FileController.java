package ir.sbu.golestan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Ali Asghar on 23/06/2017.
 */
@Controller
@RequestMapping("api/file")
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity singleFileUpload(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return ResponseEntity.ok("please select a file to upload");
        }

        return null;
    }

    @GetMapping("get/{filename:.*}")
    public ResponseEntity getFile(@PathVariable String filename){
        return null;
    }
}

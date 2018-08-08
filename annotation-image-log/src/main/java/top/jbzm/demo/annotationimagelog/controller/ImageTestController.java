package top.jbzm.demo.annotationimagelog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.jbzm.demo.annotationimagelog.aop.LogToolNB;
import top.jbzm.demo.annotationimagelog.common.FilePath;
import top.jbzm.demo.annotationimagelog.util.UploadFile;

import java.io.IOException;

/**
 * @author jbzm
 * @date 201810:56 AM
 **/
@RestController
public class ImageTestController {

    private final UploadFile uploadFile;

    @Autowired
    public ImageTestController(UploadFile uploadFile) {
        this.uploadFile = uploadFile;
    }

    @PostMapping(value = "test01")
    @LogToolNB
    public String test01(MultipartFile file) throws IOException {
        return uploadFile.ftpUploadFileInputStream(file.getInputStream(), "test2.sh", FilePath.BASE_PATH.getContent());
    }

    @PostMapping("test02")
    @LogToolNB
    public String test02(String one, String two) {
        int a = 1 / 0;
        return "jbzm-test02";
    }

    @GetMapping("test03")
    @LogToolNB(logType = "rabbitmq")
    public String test03(String one, String two) {
        return "jbzm-test03";
    }
}
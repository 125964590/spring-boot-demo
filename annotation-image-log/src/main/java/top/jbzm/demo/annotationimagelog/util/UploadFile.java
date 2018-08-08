package top.jbzm.demo.annotationimagelog.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.jbzm.demo.annotationimagelog.common.FilePath;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author jbzm
 * @date 20182:44 PM
 **/
@Slf4j
@Component
public class UploadFile {

    private final FtpClientPool ftpClientPool;

    @Autowired
    public UploadFile(FtpClientPool ftpClientPool) {
        this.ftpClientPool = ftpClientPool;
    }

    public String ftpUploadFileInputStream(InputStream fileInput, String fileName, String savePath) {

        log.info("===上传文件开始===");
        //从连接池获取ftp 客户端
        final FTPClient ftpClient = ftpClientPool.getFTPClient();
        try {
            //目录不存在，创建目录
            boolean makeDir = ftpClient.makeDirectory(savePath);
            //切换工作目录
            boolean changeWork = ftpClient.changeWorkingDirectory(savePath);
            //ftp上传服务器
            boolean storeFile = ftpClient.storeFile(fileName, fileInput);
            log.info("" + makeDir + changeWork + storeFile);
            log.info("===上传文件结束===");
            return FilePath.PICTURE_SAVE_URL.getContent() + fileName;
        } catch (IOException e) {
            log.error("ex", e);
        } finally {
            //回收到连接池
            ftpClientPool.returnFTPClient(ftpClient);
            return "";
        }
    }
}
package com.example.demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class CsvUploadController {

	@Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/upload/{filename}", method = RequestMethod.POST)
    public String upload(@PathVariable String filename,
            @RequestParam("fileData") MultipartFile multipartFile){

        try {
            // アップロードファイルを保存
            File uploadFile = new File(filename);
            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream uploadFileStream =
                    new BufferedOutputStream(new FileOutputStream(uploadFile));
            uploadFileStream.write(bytes);
            uploadFileStream.close();

            // ファイルを移動
            String spa = FileSystems.getDefault().getSeparator();
            String postgresPath = "C:\\Program Files\\PostgreSQL\\12\\data\\pdf";

            Path sourcePath = Paths.get("." + spa + filename);
            Path targetPath = Paths.get(postgresPath + spa + filename);
            File targetFile = targetPath.toFile();
            if (targetFile.exists()) targetFile.delete();
            Files.move(sourcePath, targetPath);

            // DBへ挿入
            StringBuffer sql = new StringBuffer();
            sql.append(" INSERT INTO File (fileName, byteData) ")
                .append(" SELECT '").append(filename)
                .append("', pg_read_binary_file('./pdf/")
                .append(filename).append("')");
            jdbcTemplate.execute(sql.toString());

            return "blank";

        } catch (Exception e) {
            // 異常終了時の処理
            e.printStackTrace();
        } catch (Throwable t) {
            // 異常終了時の処理
            t.printStackTrace();
        }

        return "systemerror";
    }
}
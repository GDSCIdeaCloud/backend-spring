package com.example.demo.domain.s3;
import com.example.demo.domain.ImageFile.ImageFile;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class S3Image extends ImageFile {
    public S3Image(MultipartFile file, String fileName, String folderName) {
        super(file,fileName,file.getContentType(),file.getSize(),folderName);
    }
}

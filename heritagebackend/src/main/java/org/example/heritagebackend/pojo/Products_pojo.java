package org.example.heritagebackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products_pojo {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private boolean availability;
    private MultipartFile image;
    private Long categoryId;
    private byte[] ImageBytes;
    public byte[] getImageBytes() throws IOException {
        return image != null ? image.getBytes() : null;
    }


}

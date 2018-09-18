package br.com.felipejunges.simplespring.resources;

import br.com.felipejunges.simplespring.domain.Registro;
import br.com.felipejunges.simplespring.services.RegistroService;
import br.com.felipejunges.simplespring.utils.UtilBase64Image;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/registros")
public class RegistroResource {

    @Autowired
    private RegistroService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Registro> find(@PathVariable int id) {
        Registro obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Registro>> findAll() {
        List<Registro> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "downloadImage/{filePath}", method = RequestMethod.GET)
    public void downloadImage(HttpServletResponse response, @PathVariable String filePath) throws IOException {
        File file = new File("img/" + filePath);
        if(file.exists()) {
            String contentType = "application/octet-stream";
            response.setContentType(contentType);
            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream(file);

            IOUtils.copy(in, out);
            out.close();
            in.close();
        }else {
            throw new FileNotFoundException();
        }
    }

    @RequestMapping(value="/getImage/{filePath}", method= RequestMethod.GET)
    public String getImage(@PathVariable String filePath) {
        String imagePath = new File("img/" + filePath).getAbsolutePath();
        String imageBase64 = UtilBase64Image.encoder(imagePath);
        return imageBase64;
    }

}

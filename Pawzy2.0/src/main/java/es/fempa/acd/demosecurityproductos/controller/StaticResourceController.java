package es.fempa.acd.demosecurityproductos.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/static")
public class StaticResourceController {

    private final ResourceLoader resourceLoader;

    public StaticResourceController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/css/{filename:.+}")
    public ResponseEntity<Resource> getCss(@PathVariable String filename) {
        return serveStaticFile("classpath:/static/css/" + filename);
    }

    @GetMapping("/js/{filename:.+}")
    public ResponseEntity<Resource> getJs(@PathVariable String filename) {
        return serveStaticFile("classpath:/static/js/" + filename);
    }

    @GetMapping("/img/{filename:.+}")
    public ResponseEntity<Resource> getImg(@PathVariable String filename) {
        return serveStaticFile("classpath:/static/img/" + filename);
    }

    private ResponseEntity<Resource> serveStaticFile(String path) {
        try {
            Resource resource = resourceLoader.getResource(path);
            if (!resource.exists()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            HttpHeaders headers = new HttpHeaders();
            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

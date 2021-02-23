package kg.softech.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;


import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class SitemapController {


    @GetMapping("/sitemap.xml")
    @ResponseBody
    public FileSystemResource getSitemap(HttpServletResponse responseFirst){
        FileOutputStream fos = null;
        try {
            // Возьмите файл
            File f = new File("C:\\Users\\Dosmir\\Desktop\\sitemap.xml");
            //Создайте новый файл
            // Убедитесь, что он не существует
            if (f.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");

            //Получение сайтмэп
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://web.imd.kg:8080/getSiteMap?baseUrl=https://www.emin.kg/product/&storeId=5"))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            /*System.out.println(response.body());*/

            //Запись в файл
            //String fileData = "Досмир красавчик";
            fos = new FileOutputStream("C:\\Users\\Dosmir\\Desktop\\sitemap.xml");
            fos.write(response.body().getBytes());
            fos.flush();
            fos.close();
        }
        catch (Exception e) {
            System.err.println(e);
        }
        responseFirst.setContentType("application/xml");
        return new FileSystemResource(new File("C:\\Users\\Dosmir\\Desktop\\sitemap.xml"));
    }
}

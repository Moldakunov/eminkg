package kg.softech.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static kg.softech.config.globalvariable.GlobalVar.SITEMAP;

@Controller
public class SitemapController {

  @GetMapping("/sitemap.xml")
  @ResponseBody
  public FileSystemResource getSitemap(HttpServletResponse responseFirst) {
    FileOutputStream fos;

    // Возьмите файл            File f = new File("C:\\Users\\Dosmir\\Desktop\\sitemap.xml");
    File f = new File(SITEMAP);

    // Получение сайтмэп
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request =
            HttpRequest.newBuilder()
                    .uri(
                            URI.create(
                                    "http://web.imd.kg:8080/getSiteMap?baseUrl=https://www.emin.kg/product/&storeId=5"))
                    .build();

    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      // Создайте новый файл
      // Убедитесь, что он не существует
      if (f.createNewFile()) {
        // Запись в файл        fos = new FileOutputStream("C:\\Users\\Dosmir\\Desktop\\sitemap.xml");
        fos = new FileOutputStream(SITEMAP);
        fos.write(response.body().getBytes());
        fos.flush();
        fos.close();
      }
    } catch (IOException | InterruptedException e) {
      System.err.println(e);
    }

    responseFirst.setContentType("application/xml");
    //        return new FileSystemResource(new File("C:\\Users\\Dosmir\\Desktop\\sitemap.xml"));
    return new FileSystemResource(new File(SITEMAP));
  }
}


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class PostController
{

    //to unable swagger

    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
        //here whenever someone calls the home page("/") we have to call the swagger API
        //in this application the swagger versions and spring versions are not compatible
        //spring 3.14 with swagger versions were not compatible
        //spring version changes to 2.5.7
    }


}

package hello.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.micronaut.http.HttpResponse.ok;

@Controller("/main")
public class MainController {

    private MainServiceImpl mainService;

    Logger logger = LoggerFactory.getLogger("hello.micronaut.MainController");

    public MainController(MainServiceImpl mainService){
        this.mainService = mainService;
    }

    @Get(uri="/track",produces = MediaType.TEXT_PLAIN)
    public String track() {
        logger.info("track");
        mainService.print();
        return "Service count :"+mainService.trackCount();
    }

    @Get(uri="/read")
    public HttpResponse read() {
        logger.info("read");
        int result = mainService.readDB();
        return ok(result);
    }

    @Get(uri="/send")
    public HttpResponse send(HttpRequest<?> request) {
        String msg = request.getParameters()
                .getFirst("msg")
                .orElse("");
        logger.info("send "+msg);
        mainService.sendMsg(msg);
        return ok();
    }
}
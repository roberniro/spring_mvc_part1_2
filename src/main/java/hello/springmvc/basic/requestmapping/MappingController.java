package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MappingController {

//    @RequestMapping({"/hello-basic", "/hello-go"}) // 다중 설정 가능
    @GetMapping ("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    // 경로 변수 매핑
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userID = {}", data);
        return "ok";
    }

    // 다중 파라미터 매핑
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable String orderId) {
        log.info("mappingPath userId = {}, orderId = {}", userId, orderId);
        return "ok";
    }

    // 특정 파라미터 매핑
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    // 헤더 조건 매핑
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    // 미디어 타입 매핑 - HTTP 요청 헤더 Content-Type -> consume
//    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    // 미디어타입 매핑 - HTTP 요청 헤더 Accept -> produce
//    @PostMapping(value = "/mapping-produce", produces = "text/html")
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}

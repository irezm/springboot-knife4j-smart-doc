package cn.irez.doc.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 开放平台-相关接口
 *
 * @author zi
 * @since 2024-08-04
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/v3/api-docs")
public class DocController {

    /**
     * 获取API文档
     */
    @GetMapping
    public ResponseEntity<JSONObject> apiDocs(HttpServletRequest request) {
        // 从resources目录下读取openapi.json文件(注意需要与smart-doc.json中配置的outPath一致)
        //String json = ResourceUtil.readUtf8Str("openapi/openapi.json");
        String json = FileUtil.readUtf8String("D:\\Documents\\Workspace\\springboot-knife4j-smart-doc\\src\\main\\resources\\openapi\\openapi.json");
        JSONObject parse = JSONUtil.parseObj(json);

        // 获得远程host 如https://irez.cn
        String remoteHost = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        // 替换servers->url
        if (parse.containsKey("servers")) {
            parse.getJSONArray("servers").getJSONObject(0).set("url", remoteHost);
        }
        if (parse.containsKey("host")) {
            parse.set("host", remoteHost);
        }
        /*if (parse.containsKey("tags")) {
            parse.getJSONArray("tags").forEach(tag -> {
                // name与description一致
                JSONObject tagJson = (JSONObject) tag;
                // 替换paths->tags
                if (parse.containsKey("paths")) {
                    parse.getJSONObject("paths").forEach((path, pathValue) -> {
                        JSONObject pathJson = (JSONObject) pathValue;
                        if (pathJson.containsKey("tags")) {
                            pathJson.getJSONArray("tags").forEach(tagName -> {
                                if (tagJson.getStr("name").equals(tagName)) {
                                    pathJson.getJSONArray("tags").set(0, tagJson.getStr("description"));
                                }
                            });
                        }
                    });
                }
                String name = tagJson.getStr("name");
                tagJson.set("description", name);
            });
        }*/
        return ResponseEntity.ok(parse);
    }

    /**
     * 获取openapi3 API文档
     */
    @GetMapping("/swagger-config")
    public ResponseEntity<JSONObject> swaggerConfig(HttpServletRequest request) {
        // 获得远程host 如https://irez.cn
        String remoteHost = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        JSONObject parse = new JSONObject();
        parse.set("configUrl", "/v3/api-docs/swagger-config");
        parse.set("oauth2RedirectUrl", String.format("%s/swagger-ui/oauth2-redirect.html", remoteHost));
        parse.set("url", "/v3/api-docs");
        parse.set("validatorUrl", "");
        return ResponseEntity.ok(parse);
    }

}

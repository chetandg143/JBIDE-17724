package mycompany;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.facelets.impl.DefaultResourceResolver;
import com.sun.facelets.impl.ResourceResolver;

public class TemplateResolver extends DefaultResourceResolver implements ResourceResolver {

    /**
     * Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(TemplateResolver.class);

    /**
     * first check the context root, then the classpath.
     */
    public URL resolveUrl(String path) {
        log.debug("Resolving URL {}", path);
        URL url = super.resolveUrl(path);
        if (url == null) {
            String realPath = path;
            /* classpath resources don't start with / */
            if (path.startsWith("/")) {
                realPath = path.substring(1);
            }
            url = Thread.currentThread().getContextClassLoader().getResource(realPath);
        }
        return url;
    }
}
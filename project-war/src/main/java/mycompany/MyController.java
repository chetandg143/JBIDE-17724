package mycompany;

import org.ajax4jsf.model.KeepAlive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
@KeepAlive
public class MyController implements InitializingBean {

	static private Logger log = LoggerFactory.getLogger(MyController.class);

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("MyController.afterPropertiesSet()");
	}

	public String getName() {
		return "World";
	}
}

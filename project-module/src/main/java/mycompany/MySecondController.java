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
public class MySecondController implements InitializingBean {

	static private Logger log = LoggerFactory
			.getLogger(MySecondController.class);

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("MySecondController.afterPropertiesSet()");
	}

	public String getName() {
		return "Second World";
	}
}

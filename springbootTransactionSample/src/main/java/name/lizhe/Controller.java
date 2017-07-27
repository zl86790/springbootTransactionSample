package name.lizhe;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableTransactionManagement
//@Transactional
public class Controller implements Myinterface{

	@Autowired
	@Qualifier("template")
	JdbcTemplate jdbcTemplate1;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(HttpServletRequest req) {
		doLogic();
		return "helloworld";
	}

	@Transactional(rollbackFor={Exception.class, RuntimeException.class},propagation = Propagation.REQUIRES_NEW)
	public void doLogic() {
		update1();
		update2();
	}
	
	public void update1(){
		jdbcTemplate1.update("insert into table1 (id) value (1)");
	}
	
	public void update2(){
		jdbcTemplate1.update("insert into table1 (id) value (1)");
	}
}

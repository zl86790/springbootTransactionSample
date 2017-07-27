package name.lizhe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyImpl implements Myinterface {

	@Override
	@Transactional(rollbackFor={Exception.class, RuntimeException.class},propagation = Propagation.REQUIRES_NEW)
	public void doLogic() {
		update1();
		update2();
	}
	
	@Autowired
	@Qualifier("template")
	JdbcTemplate jdbcTemplate1;

	
	
	public void update1(){
		jdbcTemplate1.update("insert into table1 (id) value (1)");
	}
	
	public void update2(){
		jdbcTemplate1.update("insert into table1 (id) value (1)");
	}

}

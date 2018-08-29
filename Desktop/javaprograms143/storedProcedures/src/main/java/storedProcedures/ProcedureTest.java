package storedProcedures;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProcedureTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext c=new AnnotationConfigApplicationContext(ProcedureConfig.class);
		ProcedureDaoInterface dao=c.getBean("dao",ProcedureDaoInterface.class);
		Customer c1=dao.getCustomerprodure(1,20);
		System.out.println(c1);
	}

}

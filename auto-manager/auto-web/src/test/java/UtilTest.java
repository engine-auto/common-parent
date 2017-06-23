//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.domain.Sort.Order;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import java.util.ArrayList;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//
//// 指定我们SpringBoot工程的Application启动类
//@SpringApplicationConfiguration(classes = Application.class)
//
//// 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
//@WebAppConfiguration
//public class UtilTest {
//
//	@Autowired
//	private TUserDao dao;
//
//	@Autowired
//	private EntityManager em;
//
//	@Test
//	public void test1() {
//		dao.findByUserName("zhao");
//	}
//
//	@Test
//	public void test2() {
//		// 使用jpa提供的分页类
//		java.util.List<Order> list = new ArrayList<Sort.Order>();
//		Order order = new Order(Direction.DESC, "createTime");
//
//		list.add(order);
//
//		Sort sort = new Sort(list);
//
//		Pageable pageable = new PageRequest(0, 10, sort);
//
//		Page<Tuser> findAll = dao.findAll(pageable);
//
//	}
//
//	@Test
//	public void test3() {
//
//		Query query = em.createNativeQuery("select * from t_user limit 1");
//		Object singleResult = query.getSingleResult();
//		System.out.println(singleResult);
//	}
//
//	/*
//	 * //执行原生SQL Query nativeQuery = em.createNativeQuery(String sql);
//	 * //指定返回对象类型
//	 * nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.
//	 * aliasToBean( Class resultType)); //返回对象 List<T> resultList =
//	 * nativeQuery.getResultList();
//	 */
//}
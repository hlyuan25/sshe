package sy.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;

import org.junit.Test;

public class TestOgnl {
	@Test
	public void test() throws OgnlException {
		User user = new User();
		Group g = new Group();
		Organization o = new Organization();

		o.setOrgId("ORGID");
		g.setOrg(o);
		user.setGroup(g);

		System.out.println(user.getGroup().getOrg().getOrgId());

		String value = (String) Ognl.getValue("group.org.orgId", user);
		System.out.println(value);
	}

	@Test
	public void testOgbl() throws OgnlException {
		User user = new User();
		user.setUsername("张三");
		Group g = new Group();
		Organization o = new Organization();
		o.setOrgId("ORGID");
		g.setOrg(o);
		user.setGroup(g);

		User user2 = new User();
		user2.setUsername("李四");

		Map<String, Object> context = new HashMap<String, Object>();
		context.put("u1", user);
		context.put("u2", user2);
		String value = (String) Ognl.getValue("#u1.username+','+#u2.username",
				context, new Object());
		System.out.println(value);
	}

	@Test
	public void testOgnl05() throws OgnlException {
		User user = new User();
		user.setUsername("张三");
		Group g = new Group();
		Organization o = new Organization();
		o.setOrgId("ORGID");
		g.setOrg(o);
		user.setGroup(g);

		User user2 = new User();
		user2.setUsername("李四");

		User user3 = new User();
		user3.setUsername("王五");

		Map<String, Object> context = new HashMap<String, Object>();
		context.put("u1", user);
		context.put("u2", user2);

		String value = (String) Ognl.getValue(
				"#u1.username+ ',' + #u2.username+ ',' + username", context,
				user3);
		System.out.println(value);
	}

	@Test
	public void testOgnl06() throws OgnlException {
		User user = new User();
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("u", user);

		Ognl.getValue("#u.username = 'hailong'", context, new Object());

		System.out.println(user.getUsername());
	}

	@Test
	public void testOgnl07() throws OgnlException {
		User user = new User();
		Ognl.getValue("setUsername('wang')", user);
		String value = (String) Ognl.getValue("getUsername()", user);
		System.out.println(value);
	}

	@Test
	public void testOgnl08() throws OgnlException {
		User user = new User();
		Ognl.getValue("setUsername('wangwu')", user);
		Ognl.getValue("@System@out.println(username)", user);

	}

	@Test
	public void testOgnl09() throws OgnlException {
		Object root = new Object();
		Map<String, Object> context = new HashMap<String, Object>();
		List list = (List) Ognl.getValue("{123,'xxx','kdjfk'}", context, root);
		context.put("list", list);

		int[] intarray = (int[]) Ognl.getValue("new int[]{23,45,67}", context,
				root);
		context.put("intarray", intarray);

		Map mapvalue = (Map) Ognl.getValue(
				"#{'listvalue':#list,'intvalue':#intarray}", context, root);
		context.put("mapvalue", mapvalue);

		Ognl.getValue("@System@out.println(#list[1])", context, root);// xxx
		Ognl.getValue("@System@out.println(#intarray[2])", context, root);// 67
		Ognl.getValue("@System@out.println(#mapvalue.listvalue[0])", context,
				root); // 123
		Ognl.getValue("@System@out.println(#mapvalue['intvalue'][0])", context,
				root);// 23

	}

	@Test
	public void testOgnl10() throws OgnlException {
		List root = new ArrayList();
		User user1 = new User();
		user1.setUsername("张三");
		User user2 = new User();
		user2.setUsername("李四");
		root.add(user1);
		root.add(user2);

		Ognl.getValue("#root[0].username", root);
		Ognl.getValue("#root[1].username", root);

	}
}

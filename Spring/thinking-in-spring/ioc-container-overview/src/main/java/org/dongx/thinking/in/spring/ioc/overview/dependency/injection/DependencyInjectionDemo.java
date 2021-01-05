package org.dongx.thinking.in.spring.ioc.overview.dependency.injection;

import org.dongx.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入示例
 * 1. 通过名称的方式查找
 *
 * @author <a href="mailto:dongxiang886@gmail.com>Dongx</a>
 * @since
 */
public class DependencyInjectionDemo {

	public static void main(String[] args) {
		// 配置 XML 配置文件
		// 启动 Spring 应用上下文
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

		UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);

		System.out.println(userRepository.getUsers());

		// 依赖注入
		System.out.println(userRepository.getBeanFactory());
		System.out.println(userRepository.getBeanFactory() == beanFactory);

		ObjectFactory userFactory = userRepository.getObjectFactory();
		System.out.println(userFactory.getObject());
		
		// 依赖查找(错误)
		//System.out.println(beanFactory.getBean(BeanFactory.class));
	}
}

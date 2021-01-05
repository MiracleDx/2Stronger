package org.dongx.thinking.in.spring.ioc.overview.repository;

import org.dongx.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;

import java.util.Collection;

/**
 * 用户信息仓库
 *
 * @author <a href="mailto:dongxiang886@gmail.com>Dongx</a>
 * @since
 */
public class UserRepository {
	
	private Collection<User> users; // 自定义 Bean
	
	private BeanFactory beanFactory; // 内建非 Bean 对象（依赖）
	
	private ObjectFactory<User> objectFactory;

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public ObjectFactory<User> getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(ObjectFactory<User> objectFactory) {
		this.objectFactory = objectFactory;
	}
}

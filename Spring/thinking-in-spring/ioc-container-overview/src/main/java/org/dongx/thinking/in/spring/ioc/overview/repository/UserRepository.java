package org.dongx.thinking.in.spring.ioc.overview.repostiroy;

import org.dongx.thinking.in.spring.ioc.overview.domain.User;

import java.util.Collection;

/**
 * 用户信息仓库
 *
 * @author <a href="mailto:dongxiang886@gmail.com>Dongx</a>
 * @since
 */
public class UserRepository {
	
	private Collection<User> users;

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
}

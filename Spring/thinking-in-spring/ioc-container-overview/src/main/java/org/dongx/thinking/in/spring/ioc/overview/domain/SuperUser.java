package org.dongx.thinking.in.spring.ioc.overview.domain;

import org.dongx.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * 超级用户
 *
 * @author <a href="mailto:dongxiang886@gmail.com>Dongx</a>
 * @since
 */
@Super
public class SuperUser extends User {
	
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SuperUser{" +
				"address='" + address + '\'' +
				"} " + super.toString();
	}
}

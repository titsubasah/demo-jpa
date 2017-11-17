package com.uangteman.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

@Entity
@Table(name="t_user")
public class User implements Serializable, UserDetails{
	
  public User() {}
  
  public User(User user, List<String> userRoles) {
        this.id = user.getId();
        this.fullname = user.getFullname();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = userRoles.get(0);
    }
  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Full Name can't empty!")
	@Size(max=100,message="Max size 100")
	private String fullname;
	
	@NotBlank(message="Email can't empty!")
	@Email(message="Invalid email format")
	private String username;
	
	@NotBlank(message="Password can't empty!")
	@Size(min=6, message="Min 6 charactes")
	private String password;
	
	@Column(length=150)
	private String roles;
	
	public Long getId() {
		return id;
	}
	public User setId(Long id) {
		this.id = id;
		return this;
	}
	public String getFullname() {
		return fullname;
	}
	public User setFullname(String fullname) {
		this.fullname = fullname;
		return this;
	}	
	public String getUsername() {
		return username;
	}
	public User setUsername(String username) {
		this.username = username;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public String getRoles() {
        return roles;
    }
    public User setRoles(String roles) {
        this.roles = roles;
        return this;
    }	   
	    
	    @Override
	    public boolean isAccountNonExpired() {
	        // TODO Auto-generated method stub
	        return true;
	    }
	    @Override
	    public boolean isAccountNonLocked() {
	        // TODO Auto-generated method stub
	        return true;
	    }
	    @Override
	    public boolean isCredentialsNonExpired() {
	        // TODO Auto-generated method stub
	        return true;
	    }
	    @Override
	    public boolean isEnabled() {
	        // TODO Auto-generated method stub
	        return true;
	    }
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<String> userRoles = new ArrayList<>();
	        String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
	        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
		}
		
}

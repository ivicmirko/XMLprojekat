package rs.ac.uns.ftn.service1.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import rs.ac.uns.ftn.service1.enums.UserTypes;

@Entity
@Table(name="systemuser")
@Inheritance(strategy=InheritanceType.JOINED)
public class SystemUser implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,unique = true)
	@Size(min = 2, max = 30)
	private String username;
	
	
	@Column(nullable = false)
	@Size(min = 2, max = 30)
	private String name;
	
	@Column(nullable = false) 
	@Size(min = 2, max = 30)
	private String surname;
	
	@Column(nullable = false)
	@Size(min = 2, max = 30)
	private String address;
	
	@Column(nullable = false, unique = true)
	@Size(min = 9, max = 35)
	private String email;
	
	@Column (nullable = false)
	private String phoneNum;
	
	@Column(nullable = false)
	private String password;

	@Column
	private boolean isActive;
	
	@Column
	private boolean isNotRemoved;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

	
	public SystemUser() {
		// TODO Auto-generated constructor stub
	}

	

	public SystemUser(Long id, @Size(min = 2, max = 30) String username, List<Authority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.authorities = authorities;
		this.isActive=true;
		this.isNotRemoved=true;
	}


	

	public SystemUser(Long id, @Size(min = 2, max = 30) String username, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.authorities = (List<Authority>) authorities;
	}



	public SystemUser(@Size(min = 2, max = 30) String name, @Size(min = 2, max = 30) String surname,
			@Size(min = 2, max = 30) String address, String phoneNum, @Size(min = 9, max = 35) String email,
			String password, List<Authority> type) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.password = password;
		this.authorities = type;
		this.isActive=true;
		this.isNotRemoved=true;
	}
	
	
		
	public SystemUser(Long id, @Size(min = 2, max = 30) String username) {
		super();
		this.id = id;
		this.username = username;
	}



	public SystemUser(@Size(min = 2, max = 30) String username, @Size(min = 2, max = 30) String name,
			@Size(min = 2, max = 30) String surname, @Size(min = 2, max = 30) String address, String phoneNum,
			@Size(min = 9, max = 35) String email, String password, List<Authority> authorities) {
		super();
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		this.isActive=true;
		this.isNotRemoved=true;
	}
	public SystemUser(@Size(min = 9, max = 35) String email, String password) {
		super();
		this.email = email;
		this.password = password;
		
	}

	public SystemUser(@Size(min = 2, max = 30) String name, @Size(min = 2, max = 30) String surname,
			@Size(min = 2, max = 30) String address, String phoneNum, @Size(min = 9, max = 35) String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.isActive=true;
		this.isNotRemoved=true;
	}

	public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	


	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		
		this.password = password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.isNotRemoved;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public void setRemoved(boolean isRemoved) {
		this.isNotRemoved = isRemoved;
	}
	
	


//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
////	public void setType(String type) {
////		if(type.equals("admin")) {
////			this.type.setRolename(UserTypes.admin);
////		}else if(type.equals("agent")) {
////			this.type.setRolename(UserTypes.agent);
////		}else if(type.equals("user")) {
////			this.type.setRolename(UserTypes.user);
////		}
////	}
	
	
}

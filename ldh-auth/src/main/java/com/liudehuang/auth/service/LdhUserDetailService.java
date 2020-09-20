package com.liudehuang.auth.service;

import com.liudehuang.auth.manager.UserManager;
import com.liudehuang.common.entity.LdhAuthUser;
import com.liudehuang.common.entity.system.SystemUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LdhUserDetailService implements UserDetailsService {

    @Autowired
    private UserManager userManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * public interface UserDetails extends Serializable {
     * //获取用户包含的权限，返回权限集合，权限是一个继承了GrantedAuthority的对象
     * Collection<? extends GrantedAuthority> getAuthorities();
     * //获取密码
     * String getPassword();
     * //获取用户名
     * String getUsername();
     * //方法返回boolean类型，用于判断账户是否未过期，未过期返回true反之返回false
     * boolean isAccountNonExpired();
     * //方法用于判断账户是否未锁定
     * boolean isAccountNonLocked();
     * //用于判断用户凭证是否没过期，即密码是否未过期
     * boolean isCredentialsNonExpired();
     * //方法用于判断用户是否可用
     * boolean isEnabled();
     * }
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser systemUser = userManager.findByName(username);
        if (systemUser != null) {
            String permissions = userManager.findUserPermissions(systemUser.getUsername());
            boolean notLocked = false;
            if (StringUtils.equals(SystemUser.STATUS_VALID, systemUser.getStatus())){
                notLocked = true;
            }
            LdhAuthUser authUser = new LdhAuthUser(systemUser.getUsername(), systemUser.getPassword(), true, true, true, notLocked,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
            BeanUtils.copyProperties(systemUser,authUser);
            return authUser;
        } else {
            throw new UsernameNotFoundException("");
        }
    }


}

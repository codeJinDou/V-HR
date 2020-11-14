package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.mapper.HrMapper;
import org.javaboy.vhr.mapper.HrRoleMapper;
import org.javaboy.vhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/5/23 21:26
 * @CreateTime: 2020-05-23 21:26
 */
@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;

    @Autowired
    HrRoleMapper hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在或不正确！");
        }
        hr.setRoles(hrMapper.getRoleHrById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHr(String keywords) {
        return hrMapper.getAllHr(HrUtils.CurrentHr().getId(),keywords);
    }

    public Integer updataHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    @Transactional
    public boolean gerAllRoles(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByRoleId(hrid);
        return hrRoleMapper.addRoles(hrid, rids) == rids.length;
    }


    public Integer deleteHr(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

    public List<Hr> getChatCurrentUser() {
        return hrMapper.getChatCurrentUser(HrUtils.CurrentHr().getId());
    }
}

 

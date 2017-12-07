package smbms.service;

import smbms.entity.User;
import smbms.dao.UserMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Service Class User
*
* 2017-12-01
*/

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    
    
    public User login(String usercode,String userpassword){
    	try {
    		HashMap<String,Object> param =new HashMap<String, Object>();
    		param.put("userCode", usercode);
			List<User> users =userMapper.getUserListByMap(param);
			if(users.size()>0){
			   User user =users.get(0);
			
			if(user !=null&& user.getUserpassword().equals(userpassword)){
				return user;
			}
			}
	        } catch (Exception e) {
	         //TODO Auto-generated catch block
		       e.printStackTrace();
			throw new RuntimeException("用户登录数据查询发生了问题!"+e.getMessage());
		}
    	 return null;
    }
    @Transactional(readOnly = true)
    public User getUserById(Integer id)throws Exception{
        return userMapper.getUserById(id);
    }
    //用户列表
    @Transactional(readOnly = true)
    public List<User> getUserListByMap(Map<String,Object> param)throws Exception {
        return userMapper.getUserListByMap(param);
    }
    
    @Transactional(readOnly = true)
    public Integer getUserRecCountByMap(Map<String,Object> param)throws Exception {
    	return userMapper.getUserRecordCount(param);
    }
    
    //用户注册
    public Integer insertUser(User user)throws Exception {
        return userMapper.insertUser(user);
    }

    public Integer updateUser(User user)throws Exception {
        return userMapper.updateUser(user);
    }

    public Integer deleteUserById(Integer id)throws Exception {
        return userMapper.deleteUserById(id);
    }

}
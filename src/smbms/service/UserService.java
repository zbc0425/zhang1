package smbms.service;

import smbms.entity.User;

import java.util.List;
import java.util.Map;

/**
* Service Interface User
*
* 2017-12-01
*/
public interface UserService {
	
	/**
	 * 登陆
	 * @param usercode
	 * @param userpassword
	 * @return
	 */
	public User login(String usercode,String userpassword);

    /**
     * 通过主键Id查询User
     */
    public User getUserById(Integer id)throws Exception;

    /**
     * 通过条件Map集合查询User
     */
    public List<User> getUserListByMap(Map<String,Object> param)throws Exception;

	/**
	 * 通过条件Map集合查询User记录总数
	 */
	public Integer getUserRecCountByMap(Map<String,Object> param)throws Exception;

    /**
     * 添加User新记录
     */
    public Integer insertUser(User user)throws Exception;

    /**
      * 更新User记录
      */
    public Integer updateUser(User user)throws Exception;

    /**
      * 通过主键Id删除User
      */
    public Integer deleteUserById(Integer id)throws Exception;

}
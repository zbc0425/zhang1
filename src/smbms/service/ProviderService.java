package smbms.service;

import smbms.entity.Provider;
import java.util.List;
import java.util.Map;

/**
* Service Interface Provider
*
* 2017-12-01
*/
public interface ProviderService {

    /**
     * 通过主键Id查询Provider
     */
    public Provider getProviderById(Integer id)throws Exception;

    /**
     * 通过条件Map集合查询Provider
     */
    public List<Provider> getProviderListByMap(Map<String,Object> param)throws Exception;

	/**
	 * 通过条件Map集合查询Provider记录总数
	 */
	public Integer getProviderRecCountByMap(Map<String,Object> param)throws Exception;

    /**
     * 添加Provider新记�?
     */
    public Integer insertProvider(Provider provider)throws Exception;

    /**
      * 更新Provider记录
      */
    public Integer updateProvider(Provider provider)throws Exception;

    /**
      * 通过主键Id删除Provider
      */
    public Integer deleteProviderById(Integer id)throws Exception;

}
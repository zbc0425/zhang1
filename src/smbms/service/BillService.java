package smbms.service;

import smbms.entity.Bill;
import java.util.List;
import java.util.Map;

/**
* Service Interface Bill
*
* 2017-12-01
*/
public interface BillService {

    /**
     * 通过主键Id查询Bill
     */
    public Bill getBillById(Integer id)throws Exception;

    /**
     * 通过条件Map集合查询Bill
     */
    public List<Bill> getBillListByMap(Map<String,Object> param)throws Exception;

	/**
	 * 通过条件Map集合查询Bill记录总数
	 */
	public Integer getBillRecCountByMap(Map<String,Object> param)throws Exception;

    /**
     * 添加Bill新记�?
     */
    public Integer insertBill(Bill bill)throws Exception;

    /**
      * 更新Bill记录
      */
    public Integer updateBill(Bill bill)throws Exception;

    /**
      * 通过主键Id删除Bill
      */
    public Integer deleteBillById(Integer id)throws Exception;

}
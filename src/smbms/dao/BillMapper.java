package smbms.dao;

import smbms.entity.Bill;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
* Mapper Interface Bill
*
* 2017-12-01
*/
public interface BillMapper {

    public Bill getBillById(@Param(value = "id") Integer id)throws Exception;

    public List<Bill> getBillListByMap(Map<String,Object> param)throws Exception;

	public Integer getBillRecordCount(Map<String,Object> param)throws Exception;

    public Integer insertBill(Bill bill)throws Exception;

    public Integer updateBill(Bill bill)throws Exception;

    public Integer deleteBillById(@Param(value = "id") Integer id)throws Exception;

}
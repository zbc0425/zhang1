package smbms.dao;

import smbms.entity.Address;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
* Mapper Interface Address
*
* 2017-12-01
*/
public interface AddressMapper {

    public Address getAddressById(@Param(value = "id") Integer id)throws Exception;

    public List<Address> getAddressListByMap(Map<String,Object> param)throws Exception;

	public Integer getAddressRecordCount(Map<String,Object> param)throws Exception;

    public Integer insertAddress(Address address)throws Exception;

    public Integer updateAddress(Address address)throws Exception;

    public Integer deleteAddressById(@Param(value = "id") Integer id)throws Exception;

}
package com.alibaba.NetCTOSS.usermag.dao_handle;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.NetCTOSS.beans.userAndBusBean.MealBean;

/**
 * 资费 的操作接口
 * @author Administrator
 *
 */
public interface IMealHandleDao extends JpaRepository<MealBean, Long>,JpaSpecificationExecutor<MealBean> {
	
	/**
	 *根据id删除资费信息
	 */
	
	@Modifying
	@Query(value="delete from MealBean as m where m.mealId = ?1")
	public void deletedByMealBeanID(int id);

	
	
	
	
}

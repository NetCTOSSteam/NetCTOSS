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
	/**
	 * 修改资费信息
	 * @return 修改后的MealBean
	 */
	@Transactional
	@Modifying()
	@Query(value="update MealBean as m  set m.mealName=?1 where m.mealId = ?2 ")
	public void updateMealBean(String name ,int id);
	
	
	
	
	
}

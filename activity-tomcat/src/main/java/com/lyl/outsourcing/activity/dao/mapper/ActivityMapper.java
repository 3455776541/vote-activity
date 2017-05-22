package com.lyl.outsourcing.activity.dao.mapper;

import com.lyl.outsourcing.activity.entity.Activity;
import com.lyl.outsourcing.activity.entity.ActivityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity
     *
     * @mbg.generated
     */
    long countByExample(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity
     *
     * @mbg.generated
     */
    int deleteByExample(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity
     *
     * @mbg.generated
     */
    int insert(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity
     *
     * @mbg.generated
     */
    int insertSelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity
     *
     * @mbg.generated
     */
    List<Activity> selectByExample(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity
     *
     * @mbg.generated
     */
    Activity selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Activity record);
}
package com.lyl.outsourcing.activity.dao.mapper;

import com.lyl.outsourcing.activity.entity.RaffleItem;
import com.lyl.outsourcing.activity.entity.RaffleItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RaffleItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_raffle_item
     *
     * @mbg.generated
     */
    long countByExample(RaffleItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_raffle_item
     *
     * @mbg.generated
     */
    int deleteByExample(RaffleItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_raffle_item
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_raffle_item
     *
     * @mbg.generated
     */
    int insert(RaffleItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_raffle_item
     *
     * @mbg.generated
     */
    int insertSelective(RaffleItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_raffle_item
     *
     * @mbg.generated
     */
    List<RaffleItem> selectByExample(RaffleItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_raffle_item
     *
     * @mbg.generated
     */
    RaffleItem selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_raffle_item
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") RaffleItem record, @Param("example") RaffleItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_raffle_item
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") RaffleItem record, @Param("example") RaffleItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_raffle_item
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(RaffleItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_raffle_item
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(RaffleItem record);
}
package com.mep.database.mapper;

import com.mep.database.entity.Archive;
import com.mep.database.entity.ArchiveExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface ArchiveMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    @SelectProvider(type=ArchiveSqlProvider.class, method="countByExample")
    long countByExample(ArchiveExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    @DeleteProvider(type=ArchiveSqlProvider.class, method="deleteByExample")
    int deleteByExample(ArchiveExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    @Delete({
        "delete from \"archive\"",
        "where \"archive_id\" = #{archiveId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer archiveId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    @Insert({
        "insert into \"archive\" (\"archive_id\", \"post_id\", ",
        "\"year\", \"month\", \"created_date\", ",
        "\"updated_date\")",
        "values (#{archiveId,jdbcType=INTEGER}, #{postId,jdbcType=INTEGER}, ",
        "#{year,jdbcType=VARCHAR}, #{month,jdbcType=VARCHAR}, #{createdDate,jdbcType=TIMESTAMP}, ",
        "#{updatedDate,jdbcType=TIMESTAMP})"
    })
    int insert(Archive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    @InsertProvider(type=ArchiveSqlProvider.class, method="insertSelective")
    int insertSelective(Archive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    @SelectProvider(type=ArchiveSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="archive_id", property="archiveId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="post_id", property="postId", jdbcType=JdbcType.INTEGER),
        @Result(column="year", property="year", jdbcType=JdbcType.VARCHAR),
        @Result(column="month", property="month", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_date", property="createdDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_date", property="updatedDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Archive> selectByExampleWithRowbounds(ArchiveExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    @SelectProvider(type=ArchiveSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="archive_id", property="archiveId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="post_id", property="postId", jdbcType=JdbcType.INTEGER),
        @Result(column="year", property="year", jdbcType=JdbcType.VARCHAR),
        @Result(column="month", property="month", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_date", property="createdDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_date", property="updatedDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Archive> selectByExample(ArchiveExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    @Select({
        "select",
        "\"archive_id\", \"post_id\", \"year\", \"month\", \"created_date\", \"updated_date\"",
        "from \"archive\"",
        "where \"archive_id\" = #{archiveId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="archive_id", property="archiveId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="post_id", property="postId", jdbcType=JdbcType.INTEGER),
        @Result(column="year", property="year", jdbcType=JdbcType.VARCHAR),
        @Result(column="month", property="month", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_date", property="createdDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_date", property="updatedDate", jdbcType=JdbcType.TIMESTAMP)
    })
    Archive selectByPrimaryKey(Integer archiveId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    @UpdateProvider(type=ArchiveSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Archive record, @Param("example") ArchiveExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    @UpdateProvider(type=ArchiveSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Archive record, @Param("example") ArchiveExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    @UpdateProvider(type=ArchiveSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Archive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    @Update({
        "update \"archive\"",
        "set \"post_id\" = #{postId,jdbcType=INTEGER},",
          "\"year\" = #{year,jdbcType=VARCHAR},",
          "\"month\" = #{month,jdbcType=VARCHAR},",
          "\"created_date\" = #{createdDate,jdbcType=TIMESTAMP},",
          "\"updated_date\" = #{updatedDate,jdbcType=TIMESTAMP}",
        "where \"archive_id\" = #{archiveId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Archive record);
}
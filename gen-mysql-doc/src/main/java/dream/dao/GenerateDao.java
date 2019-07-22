package dream.dao;


import dream.entity.TableFileds;
import dream.entity.Tables;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GenerateDao {
    @Select("select table_name as name,table_comment as comment from information_schema.tables where table_schema =#{dataName} order by table_name")
    List<Tables> getAllTables(@Param("dataName") String databaseName);

    @Select("SHOW FULL FIELDS FROM ${tableName}")
    List<TableFileds> getTableFileds(@Param("tableName") String tableName);
}

package dream.service;

import dream.dao.GenerateDao;
import dream.util.DBToWordUtil;
import dream.entity.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("generateService")
public class GenerateService {

    @Autowired
    GenerateDao generateDao;

    @Autowired
    DBToWordUtil DBToWordUtil;

    @Value("${filePath}")
    private String filePath;

    @Value("${databaseName}")
    private String databaseName;

    public void generateDoc() {
        List<Tables> tables = generateDao.getAllTables(databaseName);
        DBToWordUtil.toWord(tables, filePath);
    }
}

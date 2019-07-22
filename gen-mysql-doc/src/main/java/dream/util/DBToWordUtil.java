package dream.util;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.rtf.RtfWriter2;
import dream.dao.GenerateDao;
import dream.entity.TableFileds;
import dream.entity.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.FileOutputStream;
import java.util.List;
import java.util.List;

@Service
public class DBToWordUtil {

    @Autowired
    GenerateDao generateDao;

    public void toWord(List<Tables> tables, String fileName) {
        Document document = new Document(PageSize.A4);
        try {
            RtfWriter2.getInstance(document, new FileOutputStream(fileName));
            document.open();
            Paragraph ph = new Paragraph();
            Font f = new Font();
            Paragraph p = new Paragraph("数据字典", new Font(Font.NORMAL, 24, Font.BOLD, new Color(0, 0, 0)));
            p.setAlignment(1);
            document.add(p);
            ph.setFont(f);
            for (int i = 0; i < tables.size(); i++) {
                String table_name = tables.get(i).getName();
                String table_comment = tables.get(i).getComment();
                List<TableFileds> fileds = generateDao.getTableFileds(tables.get(i).getName());
                String all = "" + (i + 1) + "、" + table_name + "(" + table_comment + ")";
                Table table = new Table(6);
                document.add(new Paragraph(""));
                table.setBorderWidth(1);
                table.setPadding(0);
                table.setSpacing(0);
                Color chade = new Color(176, 196, 222);
                Cell cell = new Cell("序号");
                cell.setBackgroundColor(chade);
                cell.setHeader(true);
                table.addCell(cell);
                cell = new Cell("字段名");
                cell.setBackgroundColor(chade);
                table.addCell(cell);
                cell = new Cell("数据类型");
                cell.setBackgroundColor(chade);
                table.addCell(cell);
                cell = new Cell("是否可为空");
                cell.setBackgroundColor(chade);
                table.addCell(cell);
                cell = new Cell("是否主键");
                cell.setBackgroundColor(chade);
                table.addCell(cell);
                cell = new Cell("注释");
                cell.setBackgroundColor(chade);
                table.addCell(cell);
                table.endHeaders();
                for (int k = 0; k < fileds.size(); k++) {
                    String Field = fileds.get(k).getField();
                    String Type = fileds.get(k).getType();
                    String Null = fileds.get(k).getNull();
                    String Key = fileds.get(k).getKey();
                    String Comment = fileds.get(k).getComment();
                    table.addCell((k + 1) + "");
                    table.addCell(Field);
                    table.addCell(Type);
                    table.addCell(Null);
                    table.addCell(Key);
                    table.addCell(Comment);
                }
                Paragraph pheae = new Paragraph(all);
                document.add(pheae);
                document.add(table);
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

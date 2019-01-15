package poi_test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import utils.DateUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class PoiTest_1 {

    public static void main(String[] args) {
        String time_str = "";
        try {
            Date time_1 = new Date();
            //keep 100 rows in memory,exceeding rows will be flushed to disk.
            Workbook wb = new SXSSFWorkbook(100);
            Sheet sh = wb.createSheet();
            for (int row_num = 0; row_num < 100000; row_num++) {
                Row row = sh.createRow(row_num);
                for (int cell_num = 0; cell_num < 10; cell_num++) {
                    Cell cell = row.createCell(cell_num);
                    String address = new CellReference(cell).formatAsString();
                    cell.setCellValue(address);
                }
            }
            FileOutputStream out;
            out = new FileOutputStream("F:/sxssf_test.xlsx");

            wb.write(out);
            out.close();
            Date time_2 = new Date();
            time_str = DateUtil.timeDifference(time_2, time_1).toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.print("Poi Test:" + time_str);
    }


}
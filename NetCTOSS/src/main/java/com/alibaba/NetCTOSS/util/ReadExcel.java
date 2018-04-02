package com.alibaba.NetCTOSS.util;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;

public class ReadExcel  {

	 public static void read() {
		 try {
			InputStream inputStream = new FileInputStream("C:/Users/Administrator/Desktop/用户.xls");
			
			Workbook workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			
			DataFormatter formatter = new DataFormatter();
			for (Row row : sheet) {
				for (Cell cell : row) {
					CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
					//单元格名称
					System.out.print(cellRef.formatAsString());
					
					//通过获取单元格值并应用任何数据格式（Date，0.00，1.23e9，$ 1.23等），获取单元格中显示的文本
					String text = formatter.formatCellValue(cell);
					System.out.println(text);
					switch (cell.getCellType()) {
					                    case Cell.CELL_TYPE_STRING:// 字符串型
					                        System.out.println(cell.getRichStringCellValue().getString());
					                        break;
					                     case Cell.CELL_TYPE_NUMERIC:// 数值型
					                         if (DateUtil.isCellDateFormatted(cell)) { // 如果是date类型则 ，获取该cell的date值
					                             System.out.println(cell.getDateCellValue());
					                         } else {// 纯数字
					                             System.out.println(cell.getNumericCellValue());
					                         }
					                         break;
					                     case Cell.CELL_TYPE_BOOLEAN:// 布尔
					                         System.out.println(cell.getBooleanCellValue());
					                         break;
					                     case Cell.CELL_TYPE_FORMULA:// 公式型
					                         System.out.println(cell.getCellFormula());
					                         break;
					                     case Cell.CELL_TYPE_BLANK:// 空值
					                         System.out.println();
					                         break;
					                     case Cell.CELL_TYPE_ERROR: // 故障
					                         System.out.println();
					                         break;
					                     default:
					                         System.out.println();
					                 }
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public static void main(String[] args) {
		read();
	}
}

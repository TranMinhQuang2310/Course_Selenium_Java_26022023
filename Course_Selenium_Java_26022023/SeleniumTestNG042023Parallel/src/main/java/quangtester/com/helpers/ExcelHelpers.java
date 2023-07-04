package quangtester.com.helpers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ExcelHelpers {
    private FileInputStream fis;
    private FileOutputStream fileOut;
    private Workbook wb;
    private Sheet sh;
    private Cell cell;
    private Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
    private Map<String, Integer> columns = new HashMap<>();

    //1. Hàm set Excel file theo Sheet cần dùng
    public void setExcelFile(String ExcelPath, String SheetName) {
        try {
            File f = new File(ExcelPath);

            //Nếu file không tồn tại
            if (!f.exists()) {
                //f.createNewFile();
                System.out.println("File doesn't exist");
            }

            fis = new FileInputStream(ExcelPath);
            wb = WorkbookFactory.create(fis);
            sh = wb.getSheet(SheetName);
            //sh = wb.getSheetAt(0); //0 - index of 1st sheet

            //Nếu sheet không null
            if (sh == null) {
                //Tạo ra 1 sheet mới
                sh = wb.createSheet(SheetName);
                System.out.println("Sheet Name doesn't exist");
            }

            this.excelFilePath = ExcelPath;

            //adding all the column header names to the map 'columns'
            sh.getRow(0).forEach(cell ->{
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //2. Hàm get Cell data từ Excel File
        //Gọi data từ Excel file theo từng ô
        //rownum : vị trí dòng
        //colnum : vị trí cột
    public String getCellData(int rownum, int colnum) {
        try{
            cell = sh.getRow(rownum).getCell(colnum);
            String CellData = null;
            switch (cell.getCellType()){
                case STRING:
                    CellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    //Nếu format dạng ngày-tháng
                    if (DateUtil.isCellDateFormatted(cell))
                    {
                        //Trả về dạng ngày-tháng
                        CellData = String.valueOf(cell.getDateCellValue());
                    }
                    else
                    {
                        //Trả về dạng số
                        CellData = String.valueOf((long)cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    CellData = "";
                    break;
            }
            return CellData;
        }catch (Exception e){
            return e.getMessage();
        }
    }

    //3. Gọi hàm getCellData ra dùng
        //rownum : vị trí dòng
        //columnName : vị trí cột
    public String getCellData(String columnName, int rownum) {
        // Trả về vị trí cột
        return getCellData(rownum, columns.get(columnName));
    }

    //4. Hàm ghi data vào lại File Excel theo từng Cell
        //String text : giá trị cần ghi
        //int rownum : vị trí dòng
        //int column : vị trí cột

    //4.1 set by column index
    public void setCellDataTheoSoIndex(String text, int rowNumber, int colNumber) {
        try {
            row = sh.getRow(rowNumber);
            if (row == null) {
                row = sh.createRow(rowNumber);
            }
            cell = row.getCell(colNumber);

            if (cell == null) {
                cell = row.createCell(colNumber);
            }
            //Set giá trị vào cột
            cell.setCellValue(text);

            XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
            //NO_FILL : Không có màu nền
            style.setFillPattern(FillPatternType.NO_FILL);
            //HorizontalAlignment.CENTER : Căn chỉnh GIỮA theo chiều ngang
            style.setAlignment(HorizontalAlignment.CENTER);
            //VerticalAlignment.CENTER : Căn chỉnh GIỮA theo chiều dọc
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            //set giá trị do User custom vào cột
            cell.setCellStyle(style);

            fileOut = new FileOutputStream(excelFilePath);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //4.2 set by column name
    public void setCellDataTheoTenCot(String text, int rowNumber, String columnName) {
        try {
            row = sh.getRow(rowNumber);
            if (row == null) {
                row = sh.createRow(rowNumber);
            }
            cell = row.getCell(columns.get(columnName));

            if (cell == null) {
                cell = row.createCell(columns.get(columnName));
            }
            cell.setCellValue(text);

            XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
            style.setFillPattern(FillPatternType.NO_FILL);
            style.setAlignment(HorizontalAlignment.LEFT);
            style.setVerticalAlignment(VerticalAlignment.CENTER);

            cell.setCellStyle(style);

            fileOut = new FileOutputStream(excelFilePath);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //5. Đọc Excel tất cả các dòng trong một Sheet
    public Object[][] getExcelData(String fileName, String sheetName) {
        Object[][] data = null;
        Workbook workbook = null;
        try {
            // load the file
            FileInputStream fis = new FileInputStream(fileName);

            // load the workbook
            workbook = new XSSFWorkbook(fis);

            // load the sheet
            Sheet sh = workbook.getSheet(sheetName);

            // load the row
            Row row = sh.getRow(0);

            //
            int noOfRows = sh.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();

            //noOfRows : số dòng đã chạy
            //noOfCols : số cột đã chạy
            System.out.println((noOfRows-1) + " - " + noOfCols);

            Cell cell;
            data = new Object[noOfRows - 1][noOfCols];

            // i là dòng => i = 1 là lấy dòng thứ 2
            // j là cột => j = 0 là lấy từ cột thứ 1
            //Hàm Excel của mình viết vòng lặp FOR cho chạy từ 1 nên là nó sẽ hiểu từ dòng 1 bỏ dòng tiêu đề ra. (dòng tiêu đề là 0)
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sh.getRow(i);
                    cell = row.getCell(j);

                    switch (cell.getCellType()) {
                        case STRING:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            data[i - 1][j] = String.valueOf(cell.getNumericCellValue());
                            break;
                        case BLANK:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                        default:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is:" + e.getMessage());
            throw new RuntimeException(e);
        }
        return data;
    }

    //6. Đọc Excel data với số dòng tuỳ ý sử dụng HashTable
    //Hàm này dùng cho trường hợp nhiều Field trong File Excel
    public int getColumns() {
        try {
            row = sh.getRow(0);
            return row.getLastCellNum();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }

    //Get last row number (lấy vị trí dòng cuối cùng tính từ 0)
    public int getLastRowNum() {
        return sh.getLastRowNum();
    }

    //Lấy số dòng có data đang sử dụng
    public int getPhysicalNumberOfRows() {
        return sh.getPhysicalNumberOfRows();
    }

    //startRow : số dòng (Không phải số lượng) BẮT ĐẦU trong file excel - 1
    //endRow : sô dòng (Không phải số lượng) KẾT THÚC trong file excel
    public Object[][] getDataHashTable(String excelPath, String sheetName, int startRow, int endRow) {
        System.out.println("Excel Path: " + excelPath);
        Object[][] data = null;

        try {
            File f = new File(excelPath);
            if (!f.exists()) {
                try {
                    System.out.println("File Excel path not found.");
                    throw new IOException("File Excel path not found.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            fis = new FileInputStream(excelPath);

            wb = new XSSFWorkbook(fis);

            sh = wb.getSheet(sheetName);

            int rows = getLastRowNum();
            int columns = getColumns();

            System.out.println("Row: " + rows + " - Column: " + columns);
            System.out.println("StartRow: " + startRow + " - EndRow: " + endRow);

            data = new Object[(endRow - startRow) + 1][1];
            Hashtable<String, String> table = null;
            for (int rowNums = startRow; rowNums <= endRow; rowNums++) {
                table = new Hashtable<>();
                for (int colNum = 0; colNum < columns; colNum++) {
                    table.put(getCellData(0, colNum), getCellData(rowNums, colNum));
                }
                data[rowNums - startRow][0] = table;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

}

package com.jmk.upload.service;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jmk.upload.model.UploadFileResponse;

@Service
public class DataStorageServiceImpl implements DataStorageService{

	@Override
	public UploadFileResponse storeData(MultipartFile file) {
		try(Workbook workbook=new XSSFWorkbook(file.getInputStream())) {
			Iterator<Sheet> sheetIterator=workbook.sheetIterator();
			while(sheetIterator.hasNext()) {
				Sheet sheet=sheetIterator.next();
				Iterator<Row> rowIterator=sheet.rowIterator();
				while(rowIterator.hasNext()) {
					Row row=rowIterator.next();
					Iterator<Cell> cellIterator=row.cellIterator();
					while(cellIterator.hasNext()) {
						Cell cell=cellIterator.next();
						System.out.println("Cell Value: "+cell.getStringCellValue());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

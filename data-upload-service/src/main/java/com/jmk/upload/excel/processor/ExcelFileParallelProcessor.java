package com.jmk.upload.excel.processor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jmk.upload.model.Base;
import com.jmk.upload.model.ExcelFile;

@Component
public class ExcelFileParallelProcessor {

	private final static Logger log = LoggerFactory.getLogger(ExcelFileParallelProcessor.class);

	private ExecutorService executorService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*16);
	
	@SuppressWarnings("unchecked")
	public <T extends Base> List<T> readExcelinParallel(ExcelFile excelFile){
		List<T> list=new ArrayList<>();
		log.info("Started excel file reading...");
		
		List<Future<List<? extends Base>>> results=new ArrayList<>(excelFile.getNoOfthreadsToProcess());
		for(int i:excelFile.getSheetThreads().keySet()) {
			results.add(executorService.submit(()->{
				return ExcelFileReader.readExcelFile(excelFile, excelFile.getSheetThreads().get(i),i==1,excelFile.getHeaderRowsSize());
			}));
		} 
		log.info("List assembling the excelf file processing results...");
		
		for(Future<List<? extends Base>> result:results) {
			try {
				list.addAll((Collection<? extends T>)result.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		log.info("end time ~~~~~~~~~~~~~~~");
		return list;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		try {
			executorService.shutdown();
			}
		 	catch (Exception e) {
		 		log.info(e.getMessage());
		 	}
	}

}


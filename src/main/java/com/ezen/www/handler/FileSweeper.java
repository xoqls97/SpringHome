package com.ezen.www.handler;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ezen.www.domain.FileVO;
import com.ezen.www.repository.FileDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
@EnableScheduling
public class FileSweeper {
	private final String BASE_PATH="C:\\springfileupload\\java\\fileUpload\\";
	
	private final FileDAO fdao;
	
	@Scheduled(cron="0 0 0 * * *")
	public void fileSweeper() {
		log.info("FileSweeper Running start~:{}",LocalDateTime.now());
		
		List<FileVO> dbList = fdao.selectListAllFile();
		
		List<String> currFiles = new ArrayList<String>();
		for(FileVO fvo : dbList) {
			String filePath = fvo.getSaveDir()+File.separator+fvo.getUuid();
			String fileName = fvo.getFileName();
			currFiles.add(BASE_PATH+filePath+"-"+fileName);
			
			if(fvo.getFileType()>0) {
				currFiles.add(BASE_PATH+filePath+"_th_"+fileName);
			}
		}
		log.info("currFile>>"+currFiles);
		
		LocalDate now = LocalDate.now();
		String today = now.toString();
		today = today.replace("-", File.separator);
		
		File dir = Paths.get(BASE_PATH + today).toFile();
		File [] allFileObjects = dir.listFiles();
		
		for(File file : allFileObjects) {
			String storedFileName = file.toPath().toString();
			if(!currFiles.contains(storedFileName)) {
				file.delete();
				log.info(">>>delte files>>>{}",storedFileName);
			}
		}
		log.info(">>> FileSweeper Running end~!!:{}",LocalDateTime.now());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

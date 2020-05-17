package com.jmk.darshan.service;

import java.time.LocalDate;
import java.util.List;

import com.jmk.darshan.model.Darshan;

public interface DarshanMgmtService {
	
	public Darshan saveDarshan(Darshan darshan);

	public List<Darshan> saveDarshans(List<Darshan> darshans);

	public Darshan findDarshanDetailsById(Long id);

	public void deleteDarshanById(Long id);

	public List<Darshan> findDarshanDetailsByDateRange(LocalDate startDate, LocalDate endDate);
}

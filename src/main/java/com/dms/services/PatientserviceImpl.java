package com.dms.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dms.dao.PatientDao;
import com.dms.dao.PatientDaoImpl;
import com.dms.model.Patient;

/**
 * @author Shashikant
 *
 */
@Service
public class PatientserviceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Override
	public boolean[] checkPatientInfo(Patient patient) {
		Boolean nameBoolean = false, addBoolean = false, mobBoolean = false, ageboolean = false, sextypeBoolean = false,
				statustypeBoolean = false, dateBoolean = false;

		Pattern pattern = Pattern.compile("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");
		Matcher matcher = pattern.matcher(patient.getMobile());

		if ("".equals(patient.getName()))
			nameBoolean = true;
		if ("".equals(patient.getAddress()))
			addBoolean = true;
		if ("".equals(patient.getMobile()) || !matcher.matches())
			mobBoolean = true;
		if (("".equals(patient.getAge())) || patient.getAge() == 0)
			ageboolean = true;
		if ("".equals(patient.getSex()))
			sextypeBoolean = true;
		if ("".equals(patient.getStatus()))
			statustypeBoolean = true;
		if ("".equals(patient.getApponitmentdate()) || patient.getApponitmentdate() == null)
			dateBoolean = true;
		return new boolean[] { nameBoolean, addBoolean, mobBoolean, ageboolean, sextypeBoolean, statustypeBoolean,
				dateBoolean };
	}

	@Transactional
	@Override
	public boolean savepatient(Patient patient) {

		return patientDao.savepatient(patient);

	}

}

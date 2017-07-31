package com.mep.domain.admin.administrator.service;

import java.util.Locale;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.mep.database.entity.Administrator;
import com.mep.domain.admin.administrator.dao.AdministratorInsertDao;
import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.message.DisplayMessage;
import com.mep.message.ResultMessages;
import com.mep.util.DateUtil;
import com.mep.util.StringUtil;

@Service
public class AdministratorInsertServiceImpl implements AdministratorInsertService {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	AdministratorInsertDao administratorInsertDao;

	@Override
	public ResultMessages validate(AdministratorDto adminDto) {

		ResultMessages resultMessages = new ResultMessages();
		Locale locale = LocaleContextHolder.getLocale();
		
		
		if(StringUtils.isEmpty(adminDto.getAdminPassword())) {
			resultMessages.addError(
					new DisplayMessage(messageSource.getMessage("NotBlank", new Object[] { "Password" }, locale)));
			
			return resultMessages;
		}
		
		if(!StringUtil.validatePassword(adminDto.getAdminPassword())) {
			resultMessages.addError(
					new DisplayMessage(messageSource.getMessage("MEP00002", new Object[] { "Password" }, locale)));
			
			return resultMessages;
		}
		
		if(!Objects.equals(adminDto.getAdminPassword(), adminDto.getAdminConfirmPassword())) {
			resultMessages.addError(
					new DisplayMessage(messageSource.getMessage("MEP00001", new Object[] { "Password", "Confirm Password" }, locale)));
		}		
		
		return resultMessages;
	}

	@Override
	public boolean insertAdministrator(AdministratorDto adminDto)
			throws Exception {

		administratorInsertDao.insertAdministrator(setDtoModelToEntityModel(adminDto));
		
		return true;
	}
	
	private Administrator setDtoModelToEntityModel(AdministratorDto adminDto) throws Exception {
		Administrator admin = new Administrator();
		
		String encryptPassword = encryptPassword(adminDto.getAdminPassword());
		
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminEmail(adminDto.getAdminEmail());
		admin.setAdminPassword(encryptPassword);
		admin.setCreatedDate(DateUtil.getCurrentTime());
		
		return admin;
	}
	
	private String encryptPassword(String password) throws Exception {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		return passwordEncoder.encode(password); 
	}

}

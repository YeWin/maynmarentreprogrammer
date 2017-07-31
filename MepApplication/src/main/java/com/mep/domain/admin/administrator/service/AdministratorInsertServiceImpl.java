package com.mep.domain.admin.administrator.service;

import java.util.Locale;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.mep.database.entity.Administrator;
import com.mep.domain.admin.administrator.dao.AdministratorInsertDao;
import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.message.DisplayMessage;
import com.mep.message.ResultMessages;
import com.mep.util.DateUtil;

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
	
	public Administrator setDtoModelToEntityModel(AdministratorDto adminDto) {
		Administrator admin = new Administrator();
		
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminEmail(adminDto.getAdminEmail());
		admin.setAdminPassword(adminDto.getAdminPassword());
		admin.setCreatedDate(DateUtil.getCurrentTime());
		
		return admin;
	}

}

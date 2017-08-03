package com.mep.domain.admin.post.dao;

import com.mep.database.entity.Administrator;

public interface AdministratorReferDao {

	Administrator getAdminIdByEmail(String admin_email);
}

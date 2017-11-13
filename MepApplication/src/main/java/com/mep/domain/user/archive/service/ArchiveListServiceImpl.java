package com.mep.domain.user.archive.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mep.domain.user.archive.dao.ArchiveListDao;
import com.mep.domain.user.archive.dto.ArchiveArticleListDto;
import com.mep.domain.user.archive.dto.ArchiveMonthListDto;
import com.mep.domain.user.archive.dto.ArchiveYearListDto;
import com.mep.domain.user.archive.entity.ArchiveList;

@Service
public class ArchiveListServiceImpl implements ArchiveListService {

	@Autowired
	ArchiveListDao archiveListDao;

	@Override
	public List<ArchiveYearListDto> getArchiveList() {

		List<ArchiveList> arhiveList = archiveListDao.getArchiveList();

		List<ArchiveYearListDto> archiveListDto = new ArrayList<>();

		List<String> year = new ArrayList<>();

		Set<String> yearHs = new HashSet<>();

		for (ArchiveList archive : arhiveList) {

			year.add(archive.getYear());

		}
		yearHs.addAll(year);
		year.clear();
		year.addAll(yearHs);

		for (String yearValue : year) {

			ArchiveYearListDto archiveYearListDto = new ArchiveYearListDto();

			archiveYearListDto.setYear(yearValue);

			archiveYearListDto
					.setMonthList(new ArrayList<ArchiveMonthListDto>());

			List<String> month = new ArrayList<>();

			Set<String> monthHs = new HashSet<>();

			for (ArchiveList archive : arhiveList) {

				if (archive.getYear().equals(yearValue)) {
					month.add(archive.getMonth());
				}

			}

			monthHs.addAll(month);
			month.clear();
			month.addAll(monthHs);

			for (String monthValue : month) {
				ArchiveMonthListDto archiveMonthListDto = new ArchiveMonthListDto();

				archiveMonthListDto
						.setArticleList(new ArrayList<ArchiveArticleListDto>());

				archiveMonthListDto.setMonth(monthValue);

				for (ArchiveList archive : arhiveList) {
					if (archive.getYear().equals(yearValue)) {

						if (archive.getMonth().equals(monthValue)) {
							ArchiveArticleListDto archiveArticleListDto = new ArchiveArticleListDto();

							archiveArticleListDto.setPostTitle(archive
									.getPostTitle());

							archiveMonthListDto.getArticleList().add(
									archiveArticleListDto);
						}
					}
				}

				archiveYearListDto.getMonthList().add(archiveMonthListDto);
			}

			archiveListDto.add(archiveYearListDto);
		}

		return archiveListDto;
	}

}

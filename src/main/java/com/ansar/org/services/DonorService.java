package com.ansar.org.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ansar.org.domain.Comment;
import com.ansar.org.domain.Donor;
import com.ansar.org.enums.ReceviedType;
import com.ansar.org.repository.DonorRepo;
import com.ansar.org.vo.DonorVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DonorService {

	private final DonorRepo donorRepo;

	@Transactional
	public void addDonorDetail(DonorVo criteria) throws ParseException {

		Donor donor = new Donor();
		BeanUtils.copyProperties(criteria, donor);

		donor.setReceviedType(ReceviedType.valueOf(criteria.getReceivedType().toUpperCase()));
		donor.setRecivedDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(criteria.getRecivedDate()));
		Comment comment = new Comment();
		comment.setDescription(criteria.getComment());

		donor.setComment(comment);
		donorRepo.save(donor);

	}

	public List<DonorVo> convertDonorsToDonorVo(List<Donor> donors) throws ParseException {

		List<DonorVo> donorVos = new ArrayList<>();

		for (Donor donor : donors) {
			DonorVo donorVo = new DonorVo();
			BeanUtils.copyProperties(donor, donorVo);
			donorVo.setComment(donor.getComment().getDescription());
			donorVo.setReceivedType(donor.getReceviedType().name());
			donorVo.setRecivedDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(donor.getRecivedDate()));
			donorVos.add(donorVo);
		}
		return donorVos;

	}

	public List<Donor> fetchAll() {

		return donorRepo.findAllByOrderByUpdatedDateDesc();
	}

	public List<Donor> fetchByAmount(Double amount) throws Exception {
		if (amount != null) {
			return donorRepo.getAllByAmount(amount);
		} else {
			throw new Exception("Invalid request");
		}
	}

}

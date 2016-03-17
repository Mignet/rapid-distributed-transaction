package com.jdw.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hd.domain.vo.TicketVo;
import com.hd.interfaces.ITicketService;
import com.jdw.entity.Ticket;
import com.jdw.mapper.TicketMapper;
import com.v5ent.distribut.entities.TransactionLock;

@Service
public class TicketService implements ITicketService{
	@Autowired
	private TicketMapper ticketMapper;
	
	@Override
	@Transactional(readOnly=false)
	public int save(TicketVo ticketVo, TransactionLock transactionLock) {
		Ticket record = new Ticket();
		BeanUtils.copyProperties(ticketVo, record);
		int i = ticketMapper.insert(record);
//		i=i/0;
		return i;
	}
}

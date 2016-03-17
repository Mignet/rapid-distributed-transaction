package com.hd.interfaces;

import com.hd.domain.vo.TicketVo;
import com.v5ent.distribut.entities.TransactionLock;

public interface ITicketService {
	public int save(TicketVo ticketVo,TransactionLock transactionLock);
}

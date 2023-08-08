package com.tovelop.maphant.service

import com.tovelop.maphant.dto.BoardNoticeDTO
import com.tovelop.maphant.dto.UpdateBoardNoticeDTO
import com.tovelop.maphant.mapper.BoardNoticeMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.annotation.Id
import org.springframework.stereotype.Service

@Service
class BoardNoticeService(@Autowired val boardNoticeMapper: BoardNoticeMapper) {
    fun insertNotice(boardNoticeDTO: BoardNoticeDTO) {
        boardNoticeMapper.insertNotice(boardNoticeDTO)
    }
    fun findNotice(noticeId: Id): BoardNoticeDTO {
        return boardNoticeMapper.findBoard(noticeId)
    }
    fun updateNotice(updateBoardNoticeDTO: UpdateBoardNoticeDTO) {
        boardNoticeMapper.updateNotice(updateBoardNoticeDTO)
    }
    fun deleteNotice(noticeId: Id) {
        boardNoticeMapper.deleteNotice(noticeId)
    }
    fun findNoticeList() {}
}
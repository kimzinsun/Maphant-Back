package com.tovelop.maphant.service

import com.tovelop.maphant.dto.*
import com.tovelop.maphant.mapper.AdminPageMapper
import com.tovelop.maphant.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class AdminPageService(@Autowired val adminPageMapper: AdminPageMapper, @Autowired val userService: UserService) {
    fun updateUserState(email: String, state: Int){
        userService.updateUserState(email, state)
    }
    fun updateUserRole(role: String, id: Int) {
        userService.updateUserRole(role, id)
    }

    /**
     * 신고 당한 글에 대한 정보들만 가져온다.
     * 신고 내용과 신과자의 대한 정보는 findReportInfo()를 통해 따로 응답.
     * sortType: 정렬 기준 (reportedAt: 오래된 신고부터, mostReportedRanking: 신고를 많이 받은 순서로)
     * reportSize: 불러올 신고의 개수.
     */
    fun findBoardReport(sortType: String, reportSize: Int): List<AdminBoardReportDTO> {
        return when(sortType){
            "reportedAt" -> adminPageMapper.findBoardReportByReportedAt(reportSize)
            "mostReportedRanking" -> adminPageMapper.findBoardReportByMostReportedRanking(reportSize)
            else -> adminPageMapper.findBoardReportBySortType(reportSize, sortType)
        }
    }
    fun findBoardReportInfo(boardId: Int): List<BoardReportInfoDTO>{
        return adminPageMapper.findBoardReportInfo(boardId)
    }

    fun findCommentReport(sortType: String, reportSize: Int): List<AdminCommentReportDTO>{
        return when(sortType){
            "reportedAt" -> adminPageMapper.findCommentReportByReportedAt(reportSize)
            "mostReportedRanking" -> adminPageMapper.findCommentReportByMostReportedRanking(reportSize)
            else -> adminPageMapper.findCommentReportBySortType(reportSize, sortType)
        }
    }
    fun findCommentReportInfo(commentId: Int): List<CommentReportInfoDTO>{
        return adminPageMapper.findCommentReportInfo(commentId)
    }

    fun insertUserReport(userReportDTO: UserReportDTO){
        adminPageMapper.insertUserReport(userReportDTO)
    }
//    fun insertBoardSanction(boardId: Int) {
//        adminPageMapper.setBoardSanction(boardId)
//    }
//    fun findCommentReport() {
//        adminPageMapper.findBoardReport()
//    }
//    fun insertCommentSanction(commentId: Int) {
//        adminPageMapper.setBoardSanction(commentId)
//    }
    fun findUserSanction() { //sanction = 제재
        return adminPageMapper.findUserSanction()
    }
}

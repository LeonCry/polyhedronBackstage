package com.leon.mapper;

import com.leon.pojo.SysNotice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysNoticeMapper {
//    向数据库中添加一条通知数据
     int addOneNotice(SysNotice sysNotice);
//删除数据
     int delOneNotice(@Param("sysNoticeId") int sysNoticeId);
//    从数据库中选择若干条未被删除的通知数据 根据接收方用户名
     List<SysNotice> selectSysNoticeByReceiveUserQQ(@Param("receiveUserQQ") String receiveUserQQ);

    //    从数据库中选择若干条未被删除的通知数据 根据发送方用户名
     List<SysNotice> selectSysNoticeBySendUserQQ(@Param("sendUserQQ") String sendUserQQ);

    //    从数据库中选择一条 未被删除 且 已知发送方和接收方 且 接收状态为 0:未被查看的状态
    SysNotice selectSysNoticeNoRepeat(@Param("receiveUserQQ") String receiveUserQQ,@Param("sendUserQQ") String sendUserQQ);

    //      更新数据
     int updateSysNoticeData(SysNotice sysNotice);

//     查询最近一次发送邮件的时间,验证是否符合5分钟设定 ,内置设定 noticeType = 3
     SysNotice mailInFiveMs (@Param("sendUserQQ") String sendUserQQ,@Param("receiveUserQQ") String receiveUserQQ,@Param("noticeType") int noticeType);

     List<SysNotice> returnAllNotice();
}

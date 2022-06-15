package com.leon.service;

import com.leon.pojo.SysNotice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysNoticeService {

    /**
     * 添加一条通知信息
     * @param sysNotice 传入通知信息该对象
     * @return 插入几条数据 -1为错误
     */
    int addOneNotice(SysNotice sysNotice);

    /**
     * 根据接收方用户名筛选处系统通知
     * @param receiveUserQQ 接收方用户名
     * @return 所有符合条件的List
     */
    List<SysNotice> selectByReceiveUserQQ(String receiveUserQQ);

    /**
     * 从数据库中选择一条 未被删除 且 已知发送方和接收方 且 接收状态为 0:未被查看的状态,为了防止多次发送好友请求
     * @param receiveUserQQ:接收用户名
     * @param sendUserQQ:发送用户名
     * @return 返回一个对象,null表示未查找到
     */
    SysNotice selectSysNoticeNoRepeat (String receiveUserQQ,String sendUserQQ);

    /**
     * 根据发送方用户名筛选处系统通知
     * @param sendUserQQ 发送方用户名
     * @return 所有符合条件的List
     */
    List<SysNotice> selectBySendQQ(String sendUserQQ);

    /**
     * 更新数据
     * @param sysNotice 传入通知信息该对象
     * @return 插入几条数据 -1为错误
     */
    int updateData(SysNotice sysNotice);
//    删除
    int delOneNotice(int sysNoticeId);
//    查询是否可发邮件
    SysNotice mailInFiveMs (String sendUserQQ,String receiveUserQQ,int noticeType);

    List<SysNotice> returnAllNotice();
}
